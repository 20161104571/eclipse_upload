package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.DriversMapper;
import com.imnu.SchoolBus.pojo.Drivers;
import com.imnu.SchoolBus.pojo.DriversExample;


@Service
@Transactional
public class DriversServiceImp implements DriversService{
	@Autowired
	private DriversMapper driversMapper;
	@Override
	public List<Drivers> findDiverByPage(int page) {
		return driversMapper.selectByExample(new DriversExample());
	}

	@Override
	public List<Drivers> getDriverList() {
		DriversExample example = new DriversExample();
		List<Drivers> list = driversMapper.selectByExample(example);
		return list;
	}

}
