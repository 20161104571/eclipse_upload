package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Vehicle;
import com.imnu.SchoolBus.service.VehicleService;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value="getVehicleList")
	public String vehicleList(Model model) {
		List<Vehicle> vehicles = vehicleService.getVehiclList();
		model.addAttribute("vehicles", vehicles);
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
