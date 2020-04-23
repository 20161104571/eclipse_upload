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
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public String tripList(Model model, String nowDate,
			@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum, 
			@RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		nowDate = (String)format1.format(date);  //获取当前日期
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
	public String userTripList(Model model) {
		List<Trip> trips = tripService.getTripsList();
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
	public String seachList(HttpServletRequest request, Model model) {
		String search_input = request.getParameter("index_none_header_sysc");//获取搜索框输入
		List<Trip> list = tripService.searchList(search_input);
		//System.out.println(list);
		if(list != null) {
			/*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
			model.addAttribute("search_result", list);
			//model.addAttribute("result_num", list.size());
			//model.addAttribute("search_key", search_input);
			return "user/searchResult";
		}
		else {
			model.addAttribute("error_search_fail", "没有找到搜索的内容");
			System.out.println("没有找到搜索的内容");
			return "user/index";
		}
	}
	
	@RequestMapping(value="getSearchLists")
	public String seachLists(HttpServletRequest request, Model model) {
		String search_input = request.getParameter("tripSearch_header");//获取搜索框输入
		List<Trip> list = tripService.searchList(search_input);
		System.out.println(list);
		if(list != null) {
			/*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
			model.addAttribute("search_results", list);
			//model.addAttribute("result_nums", list.size());
			//model.addAttribute("search_keys", search_input);
			return "admin/searchTrip";
		}
		else {
			model.addAttribute("error_search_fail", "没有找到搜索的内容");
			System.out.println("没有找到搜索的内容");
			return "admin/trip-list";
		}
	}
	
	@RequestMapping("findResultByStartAndDate")
	//@ResponseBody
	public String findResultByStartAndDate(HttpServletRequest request, Model model){
		String testInputOne = request.getParameter("testInputOne");
		String testInputTwo = request.getParameter("testInputTwo");
		//logger.info("findResultByStartAndDate===="+testInputOne);
		List<Trip> list = tripService.findResultByStartAndDate(testInputOne, testInputTwo);
		model.addAttribute("list", list);
		System.out.println(list);
		return "user/orders";/* "redirect:/getUserTripList" */
	}
	
	@RequestMapping(value="getTimeList")
	public String getTimeList(HttpServletRequest request, Model model, @RequestParam(required = false) Integer sId, 
			@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum, 
			@RequestParam(value = "pageSize",defaultValue = "1")Integer pageSize,
			@RequestParam(required = false) String ctime, ModelMap modelMap){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String nowDate = (String)format1.format(date);  //获取当前日期
		System.out.println("当前日期字符串：" + nowDate + "。");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String NowTime = (String)format2.format(date);  //获取当前时间
		System.out.println("当前时间字符串：" + NowTime + "。");
		if(pageNum == null) {
			pageNum = 1;
		}
		if(pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		Schedule schedule = scheduledService.findScheduleById(sId);
		String startTime = schedule.getStartTime();
		String endTime = schedule.getEndTime();
		model.addAttribute("schedule", schedule);
		modelMap.addAttribute("nowTime", NowTime);
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<Trip> lists = tripService.getTimeTripList(nowDate, startTime, endTime);
			PageInfo<Trip> pageInfo = new PageInfo<Trip>(lists, pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "user/timeList2";
	}
	
}
