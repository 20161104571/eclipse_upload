package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imnu.SchoolBus.pojo.Driver;
import com.imnu.SchoolBus.service.DriverService;

@Controller
//@RequestMapping(value="admin",method = RequestMethod.POST)
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping(value="admin/driverList",method = RequestMethod.GET)
	//@ResponseBody
	public String driverList(Model model) {
		List<Driver> drivers = driverService.getDriverList();
		model.addAttribute("drivers", drivers);
		return "admin/driver-list";
	}
}
