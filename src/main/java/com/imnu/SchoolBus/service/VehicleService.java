package com.imnu.SchoolBus.service;

import java.util.List;


import com.imnu.SchoolBus.pojo.Vehicle;

public interface VehicleService {
	
	void createVehicle(Vehicle vehicle);
	
	int deleteVehicle(Integer vId);
	
	List<Vehicle> getVehiclList();
}
