package com.imnu.SchoolBus.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.User;
@Transactional
public interface UserService {

	void register(User user);

	User checkCode(String code);

	void updateUserStatus(User user);

	User loginUser(User user);
	
	void createUser(User user);
	
	int deleteUser(Integer id);
	
	List<User> getUserList();
	
	List<User> getTeacherList();
	
	User findUserById(int id);
	
	boolean findUserByUsername(String username);
	
	boolean findStuByNumber(String number);
	
	boolean findStuByNameAndNum(String stuname, String stunum);
	
	boolean findUserByPhone(String phone);
	
	boolean findUserByEmail(String email);

	void registAdmin(User user);
	
	User adminLogin(String username, String password);
	
	int changePwd(int id, String newpassword);
	
	User updateMsg(int id, String username, String name, String email, String phone);

	List<User> getAdminList();
	
	int countUser(Integer count);
	
	int countComment(Integer comm);

	int countNewOrder(Integer subs);
}
