package com.imnu.SchoolBus.service;


import com.imnu.SchoolBus.pojo.User;

public interface UserService {

	void register(User user);

	User checkCode(String code);

	void updateUserStatus(User user);

	User loginUser(User user);
	
	void email(User user);

	//User LoginUser(String username, String password);

//	public boolean ResUser(User user);
//
//	boolean ValidateUser(User user);
//
//	List<User> getUserList(Integer pageNum);
//
//	List<User> getUserByData(User user);
//	
//	public boolean updateUserById(User user);
//	
//	public User selectUserById(int id);
//
//	public boolean findUserByUserName(String username);
//
//	public User login(User user);
//
//	public List<User> getUserList();
//
//	public List<User> findUserByPage(int page);



	



}
