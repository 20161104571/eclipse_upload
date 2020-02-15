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
		//int addDriver = driverMapper.createDriver(driver);
		//return addDriver>0?true:false;
		driverMapper.createDriver(driver);
	}

	@Override
	public int updateDriver(Driver driver) {
		return driverMapper.updateDriver(driver);
	}

	@Override
	public int deleteDriver(Integer dId) {
		return driverMapper.deleteDriver(dId);
	}

	@Override
	public Driver findDriverById(int dId) {
		return driverMapper.findDriverById(dId);
	}

//	@Override
//	public List<Driver> getDriverList() {
//		DriverExample example = new DriverExample();
//		List<Driver> list = driverMapper.selectByExample(example);
//		return list;
//	}
//
//	@Override
//	public boolean addDriver(Driver driver) {
//		int addDriver = driverMapper.createDriver(driver);
//		return addDriver>0?true:false;
//		
//	}
	
	
}
