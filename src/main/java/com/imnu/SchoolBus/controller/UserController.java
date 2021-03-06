package com.imnu.SchoolBus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.NoticeService;
import com.imnu.SchoolBus.service.TripService;
import com.imnu.SchoolBus.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping(value="getUserList")
	public String userList(Model model, 
			@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum, 
			@RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize) {
		if(pageNum == null) {
			pageNum = 1;
		}
		if(pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		System.out.println("当前页是:"+pageNum+"显示的条数是:"+pageSize);
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<User> users = userService.getUserList();
			System.out.println("分页数据:"+users);
			PageInfo<User> pageInfo = new PageInfo<User>(users, pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/user-list";
	}
	
	@RequestMapping("getTeacherList")
	public String teacherList(Model model, @RequestParam(required = false, value = "pageNum", defaultValue = "1")Integer pageNum,
							@RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize) {
		if(pageNum == null) {
			pageNum = 1;
		}
		if(pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		System.out.println("当前页是:"+pageNum+"显示的条数是:"+pageSize);
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<User> tl = userService.getTeacherList();
			System.out.println("分页数据:"+tl);
			PageInfo<User> pl = new PageInfo<User>(tl, pageSize);
			model.addAttribute("pageInfo", pl);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/teacher-list";
	}
	
	@RequestMapping(value="deleteUser")
	public String deleteUser(Integer id) {
		userService.deleteUser(id);
		return "redirect:/getUserList";
	}
	
	@RequestMapping(value="deleteThisUser")
	public String deleteTUser(Integer id, HttpServletRequest request, HttpSession session, String nowDate, String nowTime, Model model) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	nowDate = (String)format1.format(date);
    	nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> t = tripService.getTripsList();
		userService.deleteUser(id);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("nowTime", nowTime);
		model.addAttribute("t", t);
		model.addAttribute("notice", notice);
		request.getSession().invalidate();
		return "user/index";
	}
	
	@RequestMapping(value="deleteTeacher")
	public String deleteTeacher(Integer id) {
		userService.deleteUser(id);
		return "redirect:/getTeacherList";
	}
	
	@RequestMapping(value="updatepwd")
	public String updatePwd(int id, String newpassword, HttpSession session, String nowDate, String nowTime, Model model) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	nowDate = (String)format1.format(date);
    	nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> t = tripService.getTripsList();
		int u = userService.changePwd(id, newpassword);
		if(u>0) {
			model.addAttribute("nowDate", nowDate);
			model.addAttribute("nowTime", nowTime);
			model.addAttribute("t", t);
			model.addAttribute("notice", notice);
			return "user/index";
		}else {
			return "user/personcenter2";
		}
	}
	
	@RequestMapping(value="editUser")
	public String updateMsg(int id, String username, String name, String email, String phone, HttpServletRequest request, String nowDate, String nowTime, Model model) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	nowDate = (String)format1.format(date);
    	nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> t = tripService.getTripsList();
		User user = userService.updateMsg(id, username, name, email, phone);
		System.out.println("修改的用户信息是："+user);
		if(user != null) {
			model.addAttribute("nowDate", nowDate);
			model.addAttribute("nowTime", nowTime);
			model.addAttribute("t", t);
			model.addAttribute("notice", notice);
			request.getSession().setAttribute("users", user);
			return "user/index";
		}else {
			return "user/personcenter";
		}
	}
	
	@RequestMapping(value = "import")
	public String excelImport(@RequestParam(value="filename")MultipartFile file){
		String fileName = file.getOriginalFilename();
		boolean result = false;
		System.out.println(result);
		try {
			result = userService.batchImport(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result = true){
			return "redirect:/getTeacherList";
		}else{
			return "excel数据导入失败！";
		}
		
	}
	
}
