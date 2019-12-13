package com.imnu.SchoolBus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imnu.SchoolBus.service.UserService;

@Controller
public class VerifyController {
	@Autowired
	private UserService userService;
	
}
