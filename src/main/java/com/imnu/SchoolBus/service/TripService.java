package com.imnu.SchoolBus.service;

import java.util.List;


import com.imnu.SchoolBus.pojo.Trip;

public interface TripService {
	
	void createTrip(Trip trip);
	
	int deleteTrip(Integer tId);
	
	List<Trip> getTripList();
	
	List<Trip> searchList(String search_input);
	
	Trip findSubsTripById(int tId);
	
	void updateSeats(Trip trip);

	void addSeats(Trip trip);
}
