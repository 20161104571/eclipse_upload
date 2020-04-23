package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Vehicle;
import com.imnu.SchoolBus.service.VehicleService;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value="getVehicleList")
	public String vehicleList(Model model,
			@RequestParam(required = false, value = "pageNum", defaultValue = "1")Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize) {
		if(pageNum == null) {
			pageNum = 1;
		}
		if(pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<Vehicle> vehicles = vehicleService.getVehiclList();
			PageInfo<Vehicle> pageInfo = new PageInfo<Vehicle>(vehicles, pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/vehicle-list";
	}
	
	@RequestMapping(value="saveVehicle")
	public String createVehicle(Vehicle vehicle) {
		vehicleService.createVehicle(vehicle);
		return "redirect:/getVehicleList";
	}
	
	@RequestMapping(value="deleteVehicle")
	public String deleteVehicle(Integer vId) {
		vehicleService.deleteVehicle(vId);
		return "redirect:/getVehicleList";
	}
}
