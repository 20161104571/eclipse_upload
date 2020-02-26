package com.imnu.SchoolBus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;

@Controller
@RequestMapping(value="/admins",method = RequestMethod.POST)

public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/loginAdmin")
    public String login(User user, Model model){
        User u = userService.loginAdmin(user);
        if (u !=null){
            return "admin/aindex";
        }
        return "admin/adminLogin";
    }

}
