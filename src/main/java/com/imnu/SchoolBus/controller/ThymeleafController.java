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
	public String index(Model model, String nowDate, String nowTime) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		nowDate = (String)format1.format(date);
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> t = tripService.getTripsList();
		model.addAttribute("notice", notice);
		model.addAttribute("t", t);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("nowTime", nowTime);
		return "user/index";
	}
	
	@RequestMapping("aindex")
	public String adminIndex(User user, Integer count, Integer counts, Integer comm, Integer subs, ModelMap modelMap) {
		int c = userService.countUser(count);
		int tea = userService.countTeUser(counts);
		int com = userService.countComment(comm);
		int newor = userService.countNewOrder(subs);
		int ct = c + tea;
		modelMap.addAttribute("countuser", ct);
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
	
	@RequestMapping("tripEdit")
	public String tripEdit() {
		return "admin/trip-edit";
	}
	
	@RequestMapping("vehicle-edit")
	public String vehicleEdit() {
		return "admin/vehicle-edit";
	}
	
	@RequestMapping("notice")
	public String Notice() {
		return "user/notice";
	}
	
	@RequestMapping("orderlist")
	public String Order() {
		return "user/orderlist";
	}
	
	@RequestMapping("content")
	public String Content() {
		return "user/content";
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
