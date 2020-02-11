package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Driver;


public interface DriverService {

	//List<Driver> findDiverByPage(int page);

	List<Driver> getDriverList();

	void createDriver(Driver driver);
	
	int updateDriver(Driver driver);
	
	int deleteDriver(Integer dId);
	
	Driver findDriverById(int dId);

}
