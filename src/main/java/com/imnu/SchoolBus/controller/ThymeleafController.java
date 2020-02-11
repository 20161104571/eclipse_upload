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
	
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	@RequestMapping("driver-list")
	public String memberlist() {
		return "admin/driver-list";
	}
	
	@RequestMapping("driver-add")
	public String memberadd() {
		return "admin/driver-add";
	}
}
