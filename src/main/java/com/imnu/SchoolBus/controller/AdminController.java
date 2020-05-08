package com.imnu.SchoolBus.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "loginAdmin")
	public String login(String username, String password, 
			HttpServletRequest request, Integer count, Integer counts,
			Integer comm, Integer subs, ModelMap modelMap) throws IOException {
		User u = userService.adminLogin(username, password);
		int c = userService.countUser(count);
		int tea = userService.countTeUser(counts);
		int com = userService.countComment(comm);
		int newor = userService.countNewOrder(subs);
		int ct = c + tea;
		if(u != null) {
			modelMap.addAttribute("countuser", ct);
			modelMap.addAttribute("com", com);
			modelMap.addAttribute("newor", newor);
			request.getSession().setAttribute("user", u);
			return "admin/aindex";
		}
		return "admin/adminLogin";
		
	}
	
	@RequestMapping(value = "updateAdminPwd")
	public String updateAdmPwd(int id, String newpassword) {
		int u = userService.changePwd(id, newpassword);
		System.out.println(u);
		if(u>0) {
			return "admin/adminLogin";
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
