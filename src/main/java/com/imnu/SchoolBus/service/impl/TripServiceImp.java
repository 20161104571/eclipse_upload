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
	public List<Trip> getTripList() {
		List<Trip> list = tripMapper.getTripList();
		return list;
	}

}
