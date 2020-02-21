package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String userList(Model model) {
		List<User> users = userService.getUserList();
		model.addAttribute("users", users);
		System.out.print(users);
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
}
