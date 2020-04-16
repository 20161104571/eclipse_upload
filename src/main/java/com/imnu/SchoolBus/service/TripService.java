package com.imnu.SchoolBus.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Trip;
@Transactional
public interface TripService {
	
	void createTrip(Trip trip);
	
	int deleteTrip(Integer tId);
	
	List<Trip> getTripList();
	
	List<Trip> searchList(String search_input);
	
	Trip findSubsTripById(int tId);
	
	void updateSeats(int tId, Trip trip);

	void addSeats(int tId, Trip trip);
	
	List<Trip> getTimeTripList(Date startTime, Date endTime);
	
	Trip findTripByTime(Date startTime, Date endTime);

	Trip findTripsByTime(Date ctime);

}
