package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Driver;

@Transactional
public interface DriverService {

	List<Driver> getDriverList();

	void createDriver(Driver driver);
	
	void updateDriver(Driver driver);
	
	int deleteDriver(Integer dId);
	
	Driver findDriverById(int dId);

}
