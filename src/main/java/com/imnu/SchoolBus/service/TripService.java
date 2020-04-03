package com.imnu.SchoolBus.service;

import java.util.Date;
import java.util.List;

import com.imnu.SchoolBus.pojo.Trip;

public interface TripService {
	
	void createTrip(Trip trip);
	
	int deleteTrip(Integer tId);
	
	List<Trip> getTripList();
	
	List<Trip> searchList(String search_input);
	
	Trip findSubsTripById(int tId);
	
	void updateSeats(int tId, Trip trip);

	void addSeats(int tId, Trip trip);
	
	List<Trip> getTimeTripList();
	
	Trip findTripByTime(Date ctime);
	
}
