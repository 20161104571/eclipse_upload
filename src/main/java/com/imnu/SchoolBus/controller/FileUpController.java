package com.imnu.SchoolBus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;

@Controller
public class FileUpController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("adminmegshow")
	public String adminShow(@RequestParam("show") Integer id,ModelMap mp) {
		User u = userService.findUserById(id);
		mp.addAttribute("user", u);
		return "admin/aindex";
	}
}
