package com.imnu.SchoolBus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.NoticeService;
import com.imnu.SchoolBus.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="getUserList")
//	public String userList(Model model) {
//		List<User> users = userService.getUserList();
//		model.addAttribute("users", users);
//		System.out.print(users);
//		return "admin/user-list";
//	}
	public String UserList(Model model, 
			@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum, 
			@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize) {
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
	
	@RequestMapping(value="deleteUser")
	public String deleteUser(Integer id) {
		userService.deleteUser(id);
		return "redirect:/getUserList";
	}
	
	@RequestMapping(value="saveUser")
	public String createUser(User user) {
		userService.createUser(user);
		return "redirect:/getUserList";
	}
	
	@RequestMapping(value="shownotice")
	public String showNotice(Model model) {
		List<Notice> notices = noticeService.getNoticeList();
		model.addAttribute("notices", notices);
		return "user/notice";
	}
	
	@RequestMapping(value="getContent")
	public String getContent(Model model,int nId) {
		Notice notice = noticeService.findNoticeById(nId);
		model.addAttribute("notice", notice);
		return "user/content";
	}
	
	@RequestMapping(value="getCountUsers")
	public String countUser(Model model, int count) {
		userService.countUser(count);
		return "admin/aindex";
	}
	
	@RequestMapping(value="editUser")
	public String updateMsg(User user, HttpServletRequest request) {
		User user1 = (User)request.getSession().getAttribute("users");
		userService.updateMsg(user1);
		return "user/index";
	}
	
	
}
