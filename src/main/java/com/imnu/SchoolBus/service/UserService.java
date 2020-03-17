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

	User adminLogin(String username, String password);
	
	User changePwd(String username, String password, String newPassword);
	
	void updateMsg(User user);
	
	User findUserByUsernameAndPwd(String username, String password);

}
