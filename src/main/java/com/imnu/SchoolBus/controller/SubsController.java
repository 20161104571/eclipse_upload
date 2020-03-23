package com.imnu.SchoolBus.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Subs;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.service.SubsService;
import com.imnu.SchoolBus.service.TripService;


@Controller
public class SubsController {
	
	@Autowired
	private SubsService subsService;
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping("getOrderList")
	public String orderList(Model model) {
		List<Subs> subss = subsService.getOrderList();
		model.addAttribute("subss",subss);
		return "admin/order-list";
	}
	
	@RequestMapping("subsTrip")
	public String findSubsTripById(Model model, int tId) {
		Trip trip = tripService.findSubsTripById(tId);
		model.addAttribute("trip", trip);
		return "user/subsDetails";
	}
	
	@RequestMapping("getPersonSubsList")
	public String getPersonList(Model model) {
		List<Subs> subs = subsService.getOrderList();
		model.addAttribute("subs", subs);
		return "user/personcenter3";
	}
	
	@RequestMapping("craeteOrder")
	public String addOrder(Subs order, @Param("tId")Integer tId) {
		//subsService.findSubsById(oId); 
		Trip trip = new Trip();
		trip = tripService.findSubsTripById(tId);
		System.out.println(trip);
		//order = subsService.createOrder(order);
		//subsService.createOrder2(order);
		//System.out.println(order);
		return "user/index";
	}
	
	
}
