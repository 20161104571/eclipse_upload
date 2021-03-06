package com.imnu.SchoolBus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.pojo.Schedule;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.pojo.Vehicle;
import com.imnu.SchoolBus.service.NoticeService;
import com.imnu.SchoolBus.service.ScheduleService;
import com.imnu.SchoolBus.service.TripService;
import com.imnu.SchoolBus.service.VehicleService;

@Controller
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private ScheduleService scheduledService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value="getTripList")
	public String tripList(Model model,
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
			List<Trip> trips = tripService.getTripsList();
			PageInfo<Trip> pageInfo = new PageInfo<Trip>(trips, pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/trip-list";
	}
	
	@RequestMapping(value="getUserTripList")
	public String userTripList(Model model, String nowDate, String nowTime,
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
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		nowDate = (String)format1.format(date);
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		nowTime = (String)format2.format(date);
		model.addAttribute("nowTime", nowTime);
		model.addAttribute("nowDate", nowDate);
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<Trip> trips = tripService.getTripList(nowDate);
			PageInfo<Trip> pageInfo = new PageInfo<Trip>(trips, pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "user/orderlist";
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
	
	@RequestMapping(value="toEditTrip")
	public String updateTrip(Model model, int tId, ModelMap modelMap) {
		List<Vehicle> cardList = vehicleService.getCardList();
		Trip trip = tripService.findSubsTripById(tId);
		modelMap.addAttribute("cardList", cardList);
		model.addAttribute("trip", trip);
		return "admin/trip-edit";
	}
	
	@RequestMapping(value="editTrip")
	public String editTrip(Trip trip) {
		tripService.updateTrip(trip);
		return "redirect:/getTripList";
	}
	
	@RequestMapping(value="getSearchList")
	public String seachList(HttpServletRequest request, Model model, String nowDate, String nowTime) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		nowDate = (String)format1.format(date);
		nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> t = tripService.getTripsList();
		String search_input = request.getParameter("index_none_header_sysc");
		List<Trip> list = tripService.searchList(search_input);
		if(list != null) {
			model.addAttribute("search_result", list);
			model.addAttribute("nowDate", nowDate);
			model.addAttribute("nowTime", nowTime);
			return "user/searchResult";
		}
		else {
			model.addAttribute("error_search_fail", "没有找到搜索的内容");
			System.out.println("没有找到搜索的内容");
			model.addAttribute("notice", notice);
			model.addAttribute("t", t);
			model.addAttribute("nowDate", nowDate);
			model.addAttribute("nowTime", nowTime);
			return "user/index";
		}
	}
	
	@RequestMapping(value="getSearchLists")
	public String seachLists(HttpServletRequest request, Model model) {
		String search_input = request.getParameter("tripSearch_header");
		List<Trip> list = tripService.searchList(search_input);
		System.out.println(list);
		if(list != null) {
			model.addAttribute("search_results", list);
			return "admin/searchTrip";
		}
		else {
			model.addAttribute("error_search_fail", "没有找到搜索的内容");
			System.out.println("没有找到搜索的内容");
			return "admin/trip-list";
		}
	}
	
	@RequestMapping(value="getTimeList")
	public String getTimeList(HttpServletRequest request, Model model, @RequestParam(required = false) Integer sId, 
			@RequestParam(required = false) String ctime, ModelMap modelMap, String startTime, String endTime, Integer start){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String nowDate = (String)format1.format(date);
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String NowTime = (String)format2.format(date);
		Schedule schedule = scheduledService.findScheduleById(sId);
		startTime = schedule.getStartTime();
		endTime = schedule.getEndTime();
		start = schedule.getStartPlace();
		model.addAttribute("schedule", schedule);
		modelMap.addAttribute("nowTime", NowTime);
		modelMap.addAttribute("nowDate", nowDate);
		List<Trip> lists = tripService.getTimeTripList(start, nowDate, startTime, endTime);
		model.addAttribute("lists", lists);
		return "user/timeList2";
	}
	
}
