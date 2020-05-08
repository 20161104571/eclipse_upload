package com.imnu.SchoolBus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.pojo.Subs;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.NoticeService;
import com.imnu.SchoolBus.service.SubsService;
import com.imnu.SchoolBus.service.TripService;
import com.imnu.SchoolBus.util.MessageUtil;


@Controller
public class SubsController {
	
	@Autowired
	private SubsService subsService;
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("getOrderList")
	public String orderList(Model model,
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
			List<Subs> subss = subsService.getOrderList();
			PageInfo<Subs> pageInfo = new PageInfo<Subs>(subss, pageSize);
			model.addAttribute("pageInfo",pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/order-list";
	}
	
	@RequestMapping("getPersonSubsList")
	public String getPersonList(Model model, Integer uId, HttpServletRequest request) throws ParseException {
		User user = (User) request.getSession().getAttribute("users");
		uId = user.getId();
		Subs subs = subsService.findSubsById(uId);
		model.addAttribute("subs", subs);
		return "user/personcenter3";
	}
	
	@RequestMapping("deleOrder")
	public String deleteOrder(Integer oId) {
		subsService.delOrder(oId);
		return "redirect:/getOrderList";
	}
	
	@RequestMapping("deleUserOrder")
	public String deleteUserOrder(Integer oId, Trip trip) {
		Subs subs = subsService.findSubsById(oId);
		int tid = subs.gettId();
		tripService.findSubsTripById(tid);
		subsService.delOrder(oId);
		tripService.addSeats(tid, trip);
		return "redirect:/getUserTripList";
	}
	
	@RequestMapping("subsTrip")
	public String findSubsTripById(Model model, int tId, Integer remain_seats, Integer nId, String nowDate, String nowTime) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	nowTime = (String)format2.format(date);
		nowDate = (String)format1.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> t = tripService.getTripsList();
		Trip trip = tripService.findSubsTripById(tId);
		int seats = trip.getRemain_seats();
		System.out.println(seats);
		if(seats!=0) {
			model.addAttribute("trip", trip);
			return "user/subsDetails";
		}else {
			model.addAttribute("notice", notice);
			model.addAttribute("t", t);
			model.addAttribute("nowDate", nowDate);
			model.addAttribute("nowTime", nowTime);
			return "user/index";
		}
		
	}

    @RequestMapping(value = "sendcode",method = RequestMethod.POST)
    public String sendcode(Subs subs, int tId, Trip trip, String number, String nowDate, String nowTime, Model model) {
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	nowDate = (String)format1.format(date);
    	nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> t = tripService.getTripsList();
    	int s = subsService.addOrders(subs);
    	String code = MessageUtil.getCode();
    	String phone = subs.getPhone();
		if(s > 0) {
			MessageUtil.sendCode(phone, code);
			tripService.updateSeats(tId,trip);
			model.addAttribute("notice", notice);
			model.addAttribute("t", t);
			model.addAttribute("nowDate", nowDate);
			model.addAttribute("nowTime", nowTime);
			return "user/index";
		}else {
			return "user/subsDetails";
		}
    	
    }
	

}
