package com.imnu.SchoolBus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ThymeleafController {
	
	@RequestMapping("regist")
	public String regist() {
		return "user/regist";
	}
		
	@RequestMapping("login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("aindex")
	public String index() {
		return "admin/aindex";
	}
	
	@RequestMapping("driver-list")
	public String driverList() {
		return "admin/driver-list";
	}
	
	@RequestMapping("driver-add")
	public String driverAdd() {
		return "admin/driver-add";
	}
	
	@RequestMapping("driverEdit")
	public String driverEdit() {
		return "admin/driverEdit";
	}
	
	@RequestMapping("user-list")
	public String userList() {
		return "admin/user-list";
	}
	
	@RequestMapping("user-add")
	public String userAdd() {
		return "admin/user-add";
	}
	
	@RequestMapping("notice-list")
	public String noticeList() {
		return "admin/notice-list";
	}
	
	@RequestMapping("notice-add")
	public String noticeAdd() {
		return "admin/notice-add";
	}
	
	@RequestMapping("notice-edit")
	public String noticeEdit() {
		return "admin/notice-edit";
	}
	
	@RequestMapping("schedule-list")
	public String scheduleList() {
		return "admin/schedule-list";
	}
	
	@RequestMapping("schedule-edit")
	public String scheduleEdit() {
		return "admin/schedule-edit";
	}
	
	@RequestMapping("schedule-add")
	public String scheduleAdd() {
		return "admin/schedule-add";
	}
}
