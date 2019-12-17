package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.User;

public interface UserService {

	User LoginUser(String username, String password);

	boolean ResUser(User user);

	boolean ValidateUser(User user);

	List<User> getUserList(Integer pageNum);

	List<User> getUserByData(User user);
	
	public boolean updateUserById(User user);
	
	public User selectUserById(int id);

	User selectByUserName(String userName);


}
