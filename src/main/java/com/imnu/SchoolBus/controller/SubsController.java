package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Subs;
import com.imnu.SchoolBus.service.SubsService;


@Controller
public class SubsController {
	
	@Autowired
	private SubsService subsService;
	
	@RequestMapping("getOrderList")
	public String orderList(Model model) {
		List<Subs> subss = subsService.getOrderList();
		model.addAttribute("subss",subss);
		return "admin/order-list";
	}
}
