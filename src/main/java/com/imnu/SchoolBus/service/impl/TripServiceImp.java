package com.imnu.SchoolBus.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.TripMapper;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.service.TripService;

@Service
@Transactional
public class TripServiceImp implements TripService{
	
	@Autowired
	private TripMapper tripMapper;

	@Override
	public void createTrip(Trip trip) {
		tripMapper.createTrip(trip);
	}

	@Override
	public int deleteTrip(Integer tId) {
		return tripMapper.deleteTrip(tId);
	}

	@Override
	public List<Trip> getTripList() {
		List<Trip> list = tripMapper.getTripList();
		return list;
	}

	@Override
	public List<Trip> searchList(String search_input) {
		return tripMapper.searchList(search_input);
	}

	@Override
	public Trip findSubsTripById(int tId) {
		return tripMapper.findSubsTripById(tId);
	}

	@Override
	public void updateSeats(int tId, Trip trip) { //预约减少1座位
		tripMapper.updateSeats(tId,trip);
	}

	@Override
	public void addSeats(int tId, Trip trip) {  //取消增加1座位
		tripMapper.addSeats(tId,trip);
	}

	@Override
	public List<Trip> getTimeTripList() {
		List<Trip> list = tripMapper.getTimeTripList();
		return list;
	}

	@Override
	public Trip findTripByTime(Date ctime) {
		return tripMapper.findTripByTime(ctime);
	}

	
}
