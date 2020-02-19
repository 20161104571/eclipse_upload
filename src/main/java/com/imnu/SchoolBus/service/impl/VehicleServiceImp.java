package com.imnu.SchoolBus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.VehicleMapper;
import com.imnu.SchoolBus.pojo.Vehicle;
import com.imnu.SchoolBus.service.VehicleService;
@Service
@Transactional
public class VehicleServiceImp implements VehicleService{
	
	@Autowired
	private VehicleMapper vehicleMapper;

	@Override
	public void createVehicle(Vehicle vehicle) {
		vehicleMapper.createVehicle(vehicle);
		
	}

	@Override
	public int deleteVehicle(Integer vId) {
		return vehicleMapper.deleteVehicle(vId);
	}

	@Override
	public List<Vehicle> getVehiclList() {
		List<Vehicle> list = vehicleMapper.getVehiclList();
		return list;
	}
}
