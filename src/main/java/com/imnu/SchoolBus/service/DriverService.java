package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Driver;


public interface DriverService {

	List<Driver> findDiverByPage(int page);

	List<Driver> getDriverList();

	boolean addDriver(Driver driver);

}
