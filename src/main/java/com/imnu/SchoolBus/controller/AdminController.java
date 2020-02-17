package com.imnu.SchoolBus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imnu.SchoolBus.service.UserService;

@Controller
@RequestMapping(value="/admins",method = RequestMethod.POST)
@ResponseBody
public class AdminController {

	@Autowired
	private UserService userService;

}
