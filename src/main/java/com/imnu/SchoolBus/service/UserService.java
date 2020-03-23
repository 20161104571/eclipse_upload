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

	void registAdmin(User user);
	
	void countUser(int count);

	User adminLogin(String username, String password);
	
	int changePwd(int id, String newpassword);
	
	User updateMsg(int id, String username, String name, String email, String phone);


}
