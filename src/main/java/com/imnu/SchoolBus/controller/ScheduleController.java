package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Schedule;
import com.imnu.SchoolBus.service.ScheduleService;

@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value="getScheduleList")
	public String scheduleList(Model model) {
		List<Schedule> schedules = scheduleService.getScheduleList();
		model.addAttribute("schedules", schedules);
		System.out.println(schedules);
		return "admin/schedule-list";
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
	
	@RequestMapping(value="getQuerySchedule")
	public String querySchedule(Model model) {
		
		return null;
	}
}
