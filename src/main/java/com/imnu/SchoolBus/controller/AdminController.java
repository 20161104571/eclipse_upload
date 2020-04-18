package com.imnu.SchoolBus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
	
	@RequestMapping(value = "addAdmin")
	public String registAdmin(User user, Integer count, Integer comm, Integer subs, ModelMap modelMap) {
		userService.registAdmin(user);
		int c = userService.countUser(count);
		int com = userService.countComment(comm);
		int newor = userService.countNewOrder(subs);
		modelMap.addAttribute("countuser", c);
		modelMap.addAttribute("com", com);
		modelMap.addAttribute("newor", newor);
		return "redirect:/getAdminList";
	}
	
	@RequestMapping(value = "loginAdmin")
	public String login(String username, String password, 
			HttpServletRequest request, Integer count, 
			Integer comm, Integer subs, ModelMap modelMap, 
			HttpServletResponse response, Map<String, Object> map) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		JSONObject jsonObject;
		User u = userService.adminLogin(username, password);
		int c = userService.countUser(count);
		int com = userService.countComment(comm);
		int newor = userService.countNewOrder(subs);
		PrintWriter out = response.getWriter();
		if(u != null) {
			modelMap.addAttribute("countuser", c);
			modelMap.addAttribute("com", com);
			modelMap.addAttribute("newor", newor);
			request.getSession().setAttribute("user", u);
			return "admin/aindex";
		}
//		if(u == null || u.equals("")) {
//			out.print(1);
//		}else 
		
		return "admin/adminLogin";
		
	}
	
	@RequestMapping(value = "updateAdminPwd")
	public String updateAdmPwd(int id, String newpassword, HttpSession session, Integer count, Integer comm, Integer subs, ModelMap modelMap) {
		int u = userService.changePwd(id, newpassword);
		int c = userService.countUser(count);
		int com = userService.countComment(comm);
		int newor = userService.countNewOrder(subs);
		modelMap.addAttribute("countuser", c);
		modelMap.addAttribute("com", com);
		modelMap.addAttribute("newor", newor);
		System.out.println(u);
		if(u>0) {
			return "admin/adminLogin";
		}else {
			return "admin/admin-edit-pwd";
		}
	}
	
	@RequestMapping(value = "logOut",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();  //这里清空当前session
        return "admin/adminLogin";
    }
	

}
