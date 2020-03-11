package com.imnu.SchoolBus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;

@Controller
@RequestMapping(value="/",method = RequestMethod.POST)

public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "addAdmin")
	public String registAdmin(User user) {
		userService.registAdmin(user);
		return "redirect:/getAdminList";
	}
	
	@RequestMapping(value = "loginAdmin")
//    public String login(User user, Model model, HttpServletRequest request, HttpSession session){
//        User u = userService.loginAdmin(user);
//        request.getSession().setAttribute("sessionUser", u);
//        if (u !=null){
//            return "admin/aindex";
//        }
//        return "admin/adminLogin";
//    }
	public String userLogin(@RequestParam("username")String username,@RequestParam("password")String password,HttpServletRequest request,HttpSession session) {
		int n=userService.adminLogin(username, password);
		if(n==1) {
			//获取session并将userName存入session对象
			request.getSession().setAttribute("username", username);
			System.out.println(username);
			return "admin/aindex";
		}
		
		return "admin/adminLogin";
	}

	
	
	

	

}
