package com.imnu.SchoolBus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Driver;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.DriverService;
import com.imnu.SchoolBus.service.UserService;

@Controller
@RequestMapping(value="/admins",method = RequestMethod.POST)
@ResponseBody
public class AdminController {
	@Autowired
	private DriverService driverService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/driverlist",method=RequestMethod.POST)
	//@ResponseBody
	public List<Driver> getDriverList(HttpServletRequest request) {
		//public ModelAndView getDriverList(Driver driver, ) {
		HttpSession session = request.getSession(true);
		List<Driver> driverlist=driverService.getDriverList();
 		ModelAndView mv = new ModelAndView();
 		session.setAttribute("dl", driverlist);
 		System.out.println(driverlist.size());
 		mv.addObject("dl",driverlist);
 		mv.setViewName("admin/driver_list.jsp");	
		return driverlist;
	}
	
	@RequestMapping("/findDriverByPage")
	@ResponseBody
	public ModelAndView findDriverByPage(@RequestParam(required = true, defaultValue = "1") int page) {
		// PageHelper插件 select * from product limit 6,10;
		PageHelper.startPage(page, 3);
		List<Driver> list = driverService.findDiverByPage(page);
		System.out.println("45");

		PageInfo<Driver> pageInfo = new PageInfo<Driver>(list);
//		new JsonResult(pageInfo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("admin/dirver_list");
		return mv;
	}
	
	@RequestMapping(value="/userlist",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserList(User user,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		List<User> userlist = userService.getUserList();
		ModelAndView mv = new ModelAndView();
 		session.setAttribute("dl", userlist);
 			mv.setViewName("admin/user_list");	
		return mv;
	}
	
	@RequestMapping("/findUserByPage")
	@ResponseBody
	public ModelAndView findUserByPage(@RequestParam(required = true, defaultValue = "1") int page) {
		// PageHelper插件 select * from product limit 6,10;
		PageHelper.startPage(page, 3);
		List<User> list = userService.findUserByPage(page);
		System.out.println("45");

		PageInfo<User> pageInfo = new PageInfo<User>(list);
		//new JsonResult(pageInfo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("admin/user_list");
		return mv;
	}
	
	
}
