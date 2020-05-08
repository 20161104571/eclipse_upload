package com.imnu.SchoolBus.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	
	boolean findUserPwd(int id, String password);
	
	boolean findUserByUsername(String username);
	
	boolean findStuByNumber(String number);
	
	boolean findStuByNameAndNum(String stuname, String stunum);
	
	boolean findUserByPhone(String phone);
	
	boolean findUserByEmail(String email);
	
	User adminLogin(String username, String password);
	
	int changePwd(int id, String newpassword);
	
	User updateMsg(int id, String username, String name, String email, String phone);

	int countUser(Integer count);
	
	int countTeUser(Integer counts);
	
	int countComment(Integer comm);

	int countNewOrder(Integer subs);
	
	boolean batchImport(String fileName, MultipartFile file) throws Exception;

	boolean checkUser(User user);
}
