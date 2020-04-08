package com.imnu.SchoolBus.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imnu.SchoolBus.pojo.Schedule;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.service.ScheduleService;
import com.imnu.SchoolBus.service.TripService;
/*
 * checi
 */
@Controller
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private ScheduleService scheduledService;
	
	@RequestMapping(value="getTripList")
	public String tripList(Model model) {
		List<Trip> trips = tripService.getTripList();
		model.addAttribute("trips", trips);
		return "admin/trip-list";
	}
	
	@RequestMapping(value="getUserTripList")
	public String userTripList(Model model) {
		List<Trip> trips = tripService.getTripList();
		model.addAttribute("trips", trips);
		return "user/orders";
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
	
	@RequestMapping(value="getSearchList")
	public String seachList(HttpServletRequest request, HttpSession httpSession, Model model) {
		String search_input = request.getParameter("index_none_header_sysc");//获取搜索框输入
		List<Trip> list = tripService.searchList(search_input);
		//System.out.println(list);
		if(list != null) {
			/*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
			model.addAttribute("search_result", list);
			model.addAttribute("result_num", list.size());
			model.addAttribute("search_key", search_input);
			return "user/searchResult";
		}
		else {
			model.addAttribute("error_search_fail", "没有找到搜索的内容");
			System.out.println("没有找到搜索的内容");
			return "user/index";
		}
	}
	
	@RequestMapping(value="getSearchLists")
	public String seachLists(HttpServletRequest request, HttpSession httpSession, Model model) {
		String searchInputTrip = request.getParameter("tripSearch_header");//获取搜索框输入
		List<Trip> list = tripService.searchList(searchInputTrip);
		System.out.println(list);
		if(list != null) {
			/*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
			model.addAttribute("search_results", list);
			model.addAttribute("result_nums", list.size());
			model.addAttribute("search_keys", searchInputTrip);
			return "admin/searchTrip";
		}
		else {
			model.addAttribute("error_search_fail", "没有找到搜索的内容");
			System.out.println("没有找到搜索的内容");
			return "admin/trip-list";
		}
	}
	
//	@RequestMapping(value="getTimeList")
//	public String getTimeTripList(Model model, int sId, Date ctime) {
//		Schedule schedule = scheduledService.findScheduleById(sId);
//		Date n = schedule.getStartTime();
//		System.out.println("n:"+n);
//		//Trip trips = tripService.findSubsTripById(tId);
//		Trip trips = tripService.findTripByTime(ctime);
//		//Date t = trips.getCtime();
////		if(t.getTime()<=n.getTime()) {
////			System.out.println("sss");
////		}
//		System.out.println(trips);
//		List<Trip> trip = tripService.getTimeTripList();
//		model.addAttribute("trip", trip);
//		System.out.println(trip);
//		return "user/timeList2";
//	}
	@RequestMapping(value="getTimeList")
	public String getTimeList(HttpServletRequest request, Model model, @RequestParam(required = false) Integer sId, 
							@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate,
							@RequestParam(required = false) String cno) {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("sId", sId);
			if(null != endDate && !"".equals(endDate)) {
				String startTime = startDate.replace("-", "");
				String endTime = endDate.replace("-", "");
				System.out.println("开始时间是:"+startTime);
				System.out.println("结束时间是:"+endTime);
				map.put("startTime", startTime);
				map.put("endTime", endTime);
			}
			Schedule schedule = scheduledService.findScheduleById(sId);
			System.out.println("cccc:"+schedule);
			map.put("cno", cno);
			 List<Trip> list = tripService.getTimeTripList();
			 model.addAttribute("list", list);
			 System.out.println("取到的符合的内容："+list);
			 return "user/timeList2";
		}finally {
			return "user/timeList";
		}
	}
	
}
