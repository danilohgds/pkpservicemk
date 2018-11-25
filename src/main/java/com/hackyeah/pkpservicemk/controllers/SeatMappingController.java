package com.hackyeah.pkpservicemk.controllers;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hackyeah.pkpservicemk.mockEntities.Seat;

@Controller
public class SeatMappingController {
	
	
	@GetMapping("/getSeats")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public ResponseEntity<ArrayList<Seat>> getSeatData(@RequestParam String tripId, 
			@RequestParam Integer WagonId, @RequestParam Integer seatCount	){
		ArrayList<Seat> seatsMap  = new ArrayList<Seat>();
		Random random = new Random();
		for (int i = 1; i <= seatCount; i++) {
			Seat seat = new Seat();
			seat.setTaken(random.nextBoolean());
			if(seat.isTaken()) seat.setPassengerId(String.valueOf(i));
			seat.setSeatId(i);			
			seatsMap.add(seat);
		}
		return ResponseEntity.status(HttpStatus.OK).body(seatsMap);
	}
}
