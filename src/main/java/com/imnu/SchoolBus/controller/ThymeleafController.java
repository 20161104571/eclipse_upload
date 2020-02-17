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
	public String driverlist() {
		return "admin/driver-list";
	}
	
	@RequestMapping("driver-add")
	public String driveradd() {
		return "admin/driver-add";
	}
	
	@RequestMapping("driverEdit")
	public String driveredit() {
		return "admin/driverEdit";
	}
	
	@RequestMapping("user-list")
	public String userlist() {
		return "admin/user-list";
	}
	
	@RequestMapping("user-add")
	public String useradd() {
		return "admin/user-add";
	}
	
	@RequestMapping("notice-list")
	public String noticelist() {
		return "admin/notice-list";
	}
}
