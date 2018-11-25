package com.hackyeah.pkpservicemk.controllers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hackyeah.pkpservicemk.mockEntities.Trip;

@Controller
@SuppressWarnings("deprecation")
public class CityMockController {

	@GetMapping("/getCities")
	@ResponseBody
	public ResponseEntity<ArrayList<String>> getAllCities() {
		ArrayList<String> plcities = new ArrayList<String>();
		plcities.add("Krakow");
		plcities.add("Warsaw");
		plcities.add("Wroclaw");
		plcities.add("Katowice");
		return ResponseEntity.status(HttpStatus.OK).body(plcities);
	}

	@GetMapping("/getTrips")
	@ResponseBody
	public ResponseEntity<ArrayList<Trip>> getTripsFromTo(@RequestParam String sourceCity,
			@RequestParam String targetCity) {
		Random r = new Random();
		Integer result = r.nextInt(1000 - 1) + 1;

		ArrayList<Trip> trips = new ArrayList<Trip>();

		Trip trip = new Trip();
		trip.setSource(sourceCity);
		trip.setDestination(targetCity);
 
		trip.setTrainName("EIC" + result.toString());
		trip.setPrice(r.nextInt(100 - 50) + 50);
		trip.setAvailableSeats(r.nextInt(100 - 1) + 1);

		final Random random = new Random();
		final int millisInDay = 24 * 60 * 60 * 1000;
		Time time = new Time((long) random.nextInt(millisInDay));
		trip.setDeparture(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
 		time.setHours(time.getHours()+2);	
 		trip.setArrival(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
		trips.add(trip);
		
		
		Trip trip2 = new Trip();
		trip2.setTripId(1);
		trip2.setSource(sourceCity);
		trip2.setDestination(targetCity);
 
		trip2.setTrainName("EIC" + String.valueOf(r.nextInt(100 - 50) + 50));
		trip2.setPrice(r.nextInt(100 - 50) + 50);
		time = new Time((long) random.nextInt(millisInDay));
		trip2.setDeparture(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
 		time.setHours(time.getHours()+2);	
		trip2.setArrival(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
		trip2.setAvailableSeats(r.nextInt(100 - 1) + 1);
		trips.add(trip2);
		
		
		Trip trip3 = new Trip();
		trip3.setTripId(2);
		trip3.setSource(sourceCity);
		trip3.setDestination(targetCity);
 
		trip3.setTrainName("EIC" + String.valueOf(r.nextInt(100 - 50) + 50));
		trip3.setPrice(r.nextInt(100 - 50) + 50);
		time = new Time((long) random.nextInt(millisInDay));
		trip3.setDeparture(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
 		time.setHours(time.getHours()+4);	
 		trip3.setArrival(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
 		trip3.setAvailableSeats(r.nextInt(100 - 1) + 1);
 		trips.add(trip3);
		return ResponseEntity.status(HttpStatus.OK).body(trips);
	}

}
