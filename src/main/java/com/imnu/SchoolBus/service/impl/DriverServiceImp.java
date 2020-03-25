package com.imnu.SchoolBus.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.DriverMapper;
import com.imnu.SchoolBus.pojo.Driver;
import com.imnu.SchoolBus.service.DriverService;

@Service
@Transactional
public class DriverServiceImp implements DriverService{
	
	@Autowired
	private DriverMapper driverMapper;

	@Override
	public List<Driver> getDriverList() {
		List<Driver> list = driverMapper.getDriverList();
		return list;
	}

	@Override
	public void createDriver(Driver driver) {
		driverMapper.createDriver(driver);
	}

	@Override
	public void updateDriver(Driver driver) {
		driverMapper.updateDriver(driver);
	}

	@Override
	public int deleteDriver(Integer dId) {
		return driverMapper.deleteDriver(dId);
	}

	@Override
	public Driver findDriverById(int dId) {
		return driverMapper.findDriverById(dId);
	}
	
}
