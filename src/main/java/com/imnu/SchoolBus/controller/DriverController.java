package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imnu.SchoolBus.pojo.Driver;
import com.imnu.SchoolBus.service.DriverService;

@Controller
//@RequestMapping(value="admin",method = RequestMethod.POST)
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping(value="getDriverList")
	//@ResponseBody
	public String driverList(Model model) {
		List<Driver> drivers = driverService.getDriverList();
		model.addAttribute("drivers", drivers);
		//System.out.println(drivers);
		return "admin/driver-list";
	}
	
	@RequestMapping(value="saveDriver")
	public String createDriver(Driver driver) {
		driverService.createDriver(driver);
		System.out.println(driver);
		return "admin/driver-list";
	}
	
	@RequestMapping(value="delete")
	public String deleteDriver(@PathVariable Integer dId) {
		driverService.deleteDriver(dId);
		return "admin/driver-list";
	}
	
	@RequestMapping(value="editDriver")
	public String updateDriver(Driver driver) {
		driverService.updateDriver(driver);
		return "redirect:getDriverList";
	}
	
}
