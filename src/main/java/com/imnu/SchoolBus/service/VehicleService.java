package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Vehicle;
@Transactional
public interface VehicleService {
	
	void createVehicle(Vehicle vehicle);
	
	int deleteVehicle(Integer vId);
	
	List<Vehicle> getVehiclList();
	
	List<Vehicle> getCardList();
}
