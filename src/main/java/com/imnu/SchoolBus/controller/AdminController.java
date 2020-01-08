package com.imnu.SchoolBus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Drivers;
import com.imnu.SchoolBus.service.DriversService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DriversService driversService;
	@RequestMapping("/findDriverByPage")
	public ModelAndView findProductByPage(@RequestParam(required = true, defaultValue = "1") int page) {
		// PageHelper插件 select * from product limit 6,10;
		PageHelper.startPage(page, 3);
		List<Drivers> list = driversService.findDiverByPage(page);


		PageInfo<Drivers> pageInfo = new PageInfo<Drivers>(list);
//		new JsonResult(pageInfo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);

		mv.setViewName("admin/dirver_list.jsp");
		return mv;
	}
	@RequestMapping("/driverlist")
	public ModelAndView getDriverList(Drivers driver, HttpServletRequest request) {
		//System.out.println("1111");
		HttpSession session = request.getSession(true);
		//System.out.println("123445");
		List<Drivers> driverlist=driversService.getDriverList();
 		ModelAndView mv = new ModelAndView();
 		session.setAttribute("dl", driverlist);
 			mv.setViewName("admin/driver_list.jsp");	
		return mv;
	}
}
