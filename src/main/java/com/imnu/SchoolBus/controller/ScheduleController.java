package com.imnu.SchoolBus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Schedule;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.service.ScheduleService;
import com.imnu.SchoolBus.service.TripService;

@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping(value="getScheduleList")
	public String scheduleList(Model model,
			@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum, 
			@RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize) {
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
			List<Schedule> schedules = scheduleService.getScheduleList();
			PageInfo<Schedule> pageInfo = new PageInfo<Schedule>(schedules, pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/schedule-list";
	}
	
	@RequestMapping(value="getSchedule")
	public String getScheduleList(Model model, String nowDate) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		nowDate = (String)format1.format(date); 
		List<Schedule> schedule = scheduleService.getTimeList();
		List<Trip> trips = tripService.getTripList(nowDate);
		model.addAttribute("schedule", schedule);
		model.addAttribute("trips", trips);
		return "user/timeList";
	}
	
	@RequestMapping(value="getSchedule1")
	public String getScheduleList1(Model model, String nowDate) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		nowDate = (String)format1.format(date); 
		List<Schedule> schedule = scheduleService.getTimeList();
		List<Trip> trips = tripService.getTripList(nowDate);
		model.addAttribute("schedule", schedule);
		model.addAttribute("trips", trips);
		return "user/timeList::table_re";
	}
	
	@RequestMapping(value="getSchedule2")
	public String getScheduleList2(Model model, String nowDate) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		nowDate = (String)format1.format(date); 
		List<Schedule> schedule = scheduleService.getTimeList2();
		List<Trip> trips = tripService.getTripList(nowDate);
		model.addAttribute("schedule", schedule);
		model.addAttribute("trips", trips);
		return "user/timeList::table_re"; 
	}
	
	@RequestMapping(value="saveSchedule")
	public String createSchedules(Schedule schedule) {
		scheduleService.createSchedule(schedule);
		return "redirect:/getScheduleList";
	}
	
	@RequestMapping(value="deleteSchedule")
	public String deleteSchedule(Integer sId) {
		scheduleService.deleteSchedule(sId);
		return "redirect:/getScheduleList";
	}
	
	@RequestMapping(value="toEditSchedule")
	public String updateNotice(Model model,int sId) {
		Schedule schedule = scheduleService.findScheduleById(sId);
		model.addAttribute("schedule", schedule);
		return "admin/schedule-edit";
	}
	
}
