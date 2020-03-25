package com.imnu.SchoolBus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imnu.SchoolBus.pojo.Subs;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.service.SubsService;
import com.imnu.SchoolBus.service.TripService;
import com.imnu.SchoolBus.util.MessageUtil;


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
	public String findSubsTripById(Model model, int tId, Integer remain_seats) {
		Trip trip = tripService.findSubsTripById(tId);
		System.out.println(trip);
		int seats = trip.getRemain_seats();
		System.out.println(seats);
		if(seats!=0) {
			model.addAttribute("trip", trip);
			return "user/subsDetails";
		}else {
			return "user/index";
		}
		
	}
	
	 @RequestMapping("send")
	    public String send() {
	        return "/message";
	    }

    @RequestMapping(value = "sendcode",method = RequestMethod.POST)
    public void sendcode(String number, HttpServletResponse response) {
        MessageUtil messageUtil = new MessageUtil();
        try {
            response.getWriter().write(messageUtil.SendMessage(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@RequestMapping("getPersonSubsList")
	public String getPersonList(Model model) {
		List<Subs> subs = subsService.getOrderList();
		model.addAttribute("subs", subs);
		return "user/personcenter3";
	}
	
	@RequestMapping("craeteOrder")
	public String addOrder(Subs subs, int tId, Trip trip) {
		int s = subsService.addOrders(subs);
		if(s > 0) {
			tripService.updateSeats(tId,trip);
			return "user/index";
		}else {
			return "user/subsDetails";
		}
		
	}
	
	
}
