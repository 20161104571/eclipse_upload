package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.service.TripService;

@Controller
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping(value="getTripList")
	public String tripList(Model model) {
		List<Trip> trips = tripService.getTripList();
		model.addAttribute("trips", trips);
		System.out.println(trips);
		return "admin/trip-list";
	}
	
	@RequestMapping(value="saveTrip")
	public String createSchedules(Trip trip) {
		tripService.createTrip(trip);
		return "redirect:/getTripList";
	}
	
	@RequestMapping(value="deleteTrip")
	public String deleteTrip(Integer tId) {
		tripService.deleteTrip(tId);
		return "redirect:/getTripList";
	}
}
