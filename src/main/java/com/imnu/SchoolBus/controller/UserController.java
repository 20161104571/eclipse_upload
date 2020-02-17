package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.mapper.UserMapper;
import com.imnu.SchoolBus.pojo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="getUserList")
	public String userList(Model model) {
		List<User> users = userMapper.getUserList();
		model.addAttribute("users", users);
		System.out.print(users);
		return "admin/user-list";
	}
	
	@RequestMapping(value="deleteUser")
	public String deleteUser(Integer id) {
		userMapper.deleteUser(id);
		return "redirect:/getUserList";
	}
	
	@RequestMapping(value="saveUser")
	public String createUser(User user) {
		userMapper.createUser(user);
		return "redirect:/getUserList";
	}
}
