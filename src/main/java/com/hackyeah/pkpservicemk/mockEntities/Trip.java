package com.hackyeah.pkpservicemk.mockEntities;

import java.util.ArrayList;

public class Trip {
	private int tripId;
	private String trainName;
	private String source;
	private String destination;
	private Integer price;
	private Integer priceSecondClass;
	private String departure;
	private String arrival;
	private Integer availableSeats;
	private ArrayList<Stop> stops;
	
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getPriceSecondClass() {
		return priceSecondClass;
	}
	public void setPriceSecondClass(Integer priceSecondClass) {
		this.priceSecondClass = priceSecondClass;
	}
	public ArrayList<Stop> getStops() {
		return stops;
	}
	public void setStops(ArrayList<Stop> stops) {
		this.stops = stops;
	}
}
