package com.imnu.SchoolBus.service;


import java.util.List;

import com.imnu.SchoolBus.pojo.User;

public interface UserService {

	void register(User user);

	User checkCode(String code);

	void updateUserStatus(User user);

	User loginUser(User user);
	
	void createUser(User user);
	
	int deleteUser(Integer id);
	
	List<User> getUserList();
	
	User findUserById(int id);

	User loginAdmin(User user);
	
	void registAdmin(User user);

	int adminLogin(String username, String password);

}
