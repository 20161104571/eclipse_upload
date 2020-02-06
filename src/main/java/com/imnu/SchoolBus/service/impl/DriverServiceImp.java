package com.imnu.SchoolBus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.DriverMapper;
import com.imnu.SchoolBus.pojo.Driver;
import com.imnu.SchoolBus.pojo.DriverExample;
import com.imnu.SchoolBus.service.DriverService;

@Service
@Transactional
public class DriverServiceImp implements DriverService{
	@Autowired
	private DriverMapper driverMapper;
	@Override
	public List<Driver> findDiverByPage(int page) {
		return driverMapper.selectByExample(new DriverExample());
	}

	@Override
	public List<Driver> getDriverList() {
		DriverExample example = new DriverExample();
		List<Driver> list = driverMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean addDriver(Driver driver) {
		int addDriver = driverMapper.insertSelective(driver);
		return addDriver>0?true:false;
		
	}
	
	
}
