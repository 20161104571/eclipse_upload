package com.imnu.SchoolBus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.pojo.Vehicle;
import com.imnu.SchoolBus.service.NoticeService;
import com.imnu.SchoolBus.service.TripService;
import com.imnu.SchoolBus.service.UserService;
import com.imnu.SchoolBus.service.VehicleService;

@Controller
@RequestMapping("/")
public class ThymeleafController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping("regist")
	public String regist() {
		return "user/regist";
	}
		
	@RequestMapping("login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("adminLogin")
	public String alogin() {
		return "admin/adminLogin";
	}
	
	@RequestMapping("index")
	public String index(Model model, Integer nId, ModelMap modelMap, String nowDate, String nowTime) {
		//int n = noticeService.countNotice(nId);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		nowDate = (String)format1.format(date);  //获取当前日期
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> trip = tripService.getTripsList();
		model.addAttribute("notice", notice);
		model.addAttribute("trip", trip);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("nowTime", nowTime);
		//modelMap.addAttribute("n", n);
		return "user/index";
	}
	
	@RequestMapping("aindex")
	public String adminIndex(User user, Integer count, Integer comm, Integer subs, ModelMap modelMap) {
		int c = userService.countUser(count);
		int com = userService.countComment(comm);
		int newor = userService.countNewOrder(subs);
		modelMap.addAttribute("countuser", c);
		modelMap.addAttribute("com", com);
		modelMap.addAttribute("newor", newor);
		return "admin/aindex";
	}
	
	@RequestMapping("driver-add")
	public String driverAdd() {
		return "admin/driver-add";
	}
	
	@RequestMapping("driverEdit")
	public String driverEdit() {
		return "admin/driverEdit";
	}
	
	@RequestMapping("user-add")
	public String userAdd() {
		return "admin/user-add";
	}
	
	@RequestMapping("notice-add")
	public String noticeAdd() {
		return "admin/notice-add";
	}
	
	@RequestMapping("notice-edit")
	public String noticeEdit() {
		return "admin/notice-edit";
	}
	
	@RequestMapping("dongtai-add")
	public String dongtaiAdd() {
		return "admin/dongtai-add";
	}
	
	@RequestMapping("dongtai-edit")
	public String dongtaiEdit() {
		return "admin/dongtai-edit";
	}
	
	@RequestMapping("schedule-edit")
	public String scheduleEdit() {
		return "admin/schedule-edit";
	}
	
	@RequestMapping("schedule-add")
	public String scheduleAdd() {
		return "admin/schedule-add";
	}
	
	@RequestMapping("vehicle-add")
	public String vehicleAdd() {
		return "admin/vehicle-add";
	}
	
	@RequestMapping("trip-add")
	public String tripAdd(ModelMap modelMap) {
		List<Vehicle> cardList = vehicleService.getCardList();
		modelMap.addAttribute("cardList", cardList);
		return "admin/trip-add";
	}
	
	@RequestMapping("notice")
	public String Notice() {
		return "user/notice";
	}
	
	@RequestMapping("orders")
	public String Order() {
		return "user/orders";
	}
	
	@RequestMapping("content")
	public String Content() {
		return "user/content";
	}
	
	@RequestMapping("test")
	public String test() {
		return "user/test";
	}
	
	@RequestMapping("personcenter")
	public String person() {
		return "user/personcenter";
	}
	
	@RequestMapping("personcenter1")
	public String personmsg() {
		return "user/personcenter1";
	}
	
	@RequestMapping("personcenter2")
	public String personpwd() {
		return "user/personcenter2";
	}
	
	@RequestMapping("searchtrip")
	public String sreach() {
		return "admin/searchtrip";
	}
	
	@RequestMapping("admin-edit-pwd")
	public String editPwd() {
		return "admin/admin-edit-pwd";
	}
	
	
}
