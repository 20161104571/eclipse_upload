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
	
	@RequestMapping("adminLogin")
	public String alogin() {
		return "admin/adminLogin";
	}
	
	@RequestMapping("index")
	public String index() {
		return "user/index";
	}
	
	@RequestMapping("aindex")
	public String adminIndex() {
		return "admin/aindex";
	}
	
	@RequestMapping("driver-add")
	public String driverAdd() {
		return "admin/driver-add";
	}
	
	@RequestMapping("driverEdit")
	public String driverEdit() {
		return "admin/driverEdit";
	}
	
	@RequestMapping("user-add")
	public String userAdd() {
		return "admin/user-add";
	}
	
	@RequestMapping("notice-add")
	public String noticeAdd() {
		return "admin/notice-add";
	}
	
	@RequestMapping("notice-edit")
	public String noticeEdit() {
		return "admin/notice-edit";
	}
	
	@RequestMapping("schedule-edit")
	public String scheduleEdit() {
		return "admin/schedule-edit";
	}
	
	@RequestMapping("schedule-add")
	public String scheduleAdd() {
		return "admin/schedule-add";
	}
	
	@RequestMapping("vehicle-add")
	public String vehicleAdd() {
		return "admin/vehicle-add";
	}
	
	@RequestMapping("trip-add")
	public String tripAdd() {
		return "admin/trip-add";
	}
	
	@RequestMapping("notice")
	public String Notice() {
		return "user/notice";
	}
	
	@RequestMapping("content")
	public String Content() {
		return "user/content";
	}
	
	@RequestMapping("personcenter")
	public String person() {
		return "user/personcenter";
	}
	
	@RequestMapping("personcenter2")
	public String personpwd() {
		return "user/personcenter2";
	}
	
	@RequestMapping("searchtrip")
	public String sreach() {
		return "admin/searchtrip";
	}
	
	@RequestMapping("admin-edit-pwd")
	public String editPwd() {
		return "admin/admin-edit-pwd";
	}
	
	
}
