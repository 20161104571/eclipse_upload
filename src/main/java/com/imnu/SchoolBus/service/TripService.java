package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Trip;
@Transactional
public interface TripService {
	
	void createTrip(Trip trip);
	
	int deleteTrip(Integer tId);
	
	List<Trip> getTripList(String nowDate);
	
	List<Trip> getTripsList();
			
	List<Trip> searchList(String search_input);
	
	Trip findSubsTripById(int tId);
	
	void updateSeats(int tId, Trip trip);

	void addSeats(int tId, Trip trip);
	
	public List<Trip> findResultByStartAndDate(String testInputOne, String testInputTwo);
	
	List<Trip> getTimeTripList(Integer start, String nowDate, String startTime, String endTime);
	
	Trip findTripsByTime(String ctime);
	
	void updateTrip(Trip trip);
	
}
