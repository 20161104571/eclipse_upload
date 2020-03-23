package com.imnu.SchoolBus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String login(String username, String password, HttpServletRequest request) {
		User u = userService.adminLogin(username, password);
		if(u != null) {
			request.getSession().setAttribute("user", u);
			return "admin/aindex";
		}
		return "admin/adminLogin";
		
	}
	
	@RequestMapping(value = "updateAdminPwd")
	public String updateAdmPwd(int id, String newpassword, HttpSession session) {
		int u = userService.changePwd(id, newpassword);
		if(u>0) {
			return "admin/aindex";
		}else {
			return "admin/admin-edit-pwd";
		}
	}
	
	@RequestMapping(value = "logOut",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "admin/adminLogin";
    }
	

}
