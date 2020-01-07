package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Drivers;


public interface DriversService {

	List<Drivers> findDiverByPage(int page);

	List<Drivers> getDriverList();

}
