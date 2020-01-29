package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.User;

public interface UserService {

	//User LoginUser(String username, String password);

	public boolean ResUser(User user);

	boolean ValidateUser(User user);

	List<User> getUserList(Integer pageNum);

	List<User> getUserByData(User user);
	
	public boolean updateUserById(User user);
	
	public User selectUserById(int id);

	public boolean findUserByUserName(String username);

	public User login(User user);

	public List<User> getUserList();

	public List<User> findUserByPage(int page);



}
