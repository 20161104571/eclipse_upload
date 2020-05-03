package com.imnu.SchoolBus.service.impl;

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
	public List<Trip> getTripList(String nowDate) {
		List<Trip> list = tripMapper.getTripList(nowDate);
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
	public List<Trip> getTimeTripList(Integer start, String nowDate, String startTime, String endTime) {
		List<Trip> list = tripMapper.getTimeTripList(start, nowDate, startTime, endTime);
		return list;
	}

	@Override
	public Trip findTripsByTime(String ctime) {
		return tripMapper.findTripsByTime(ctime);
	}

	@Override
	public List<Trip> findResultByStartAndDate(String testInputOne, String testInputTwo) {
		return tripMapper.findResultByStartAndDate(testInputOne, testInputTwo);
	}

	@Override
	public List<Trip> getTripsList() {
		List<Trip> list = tripMapper.getTripsList();
		return list;
	}

	
}
