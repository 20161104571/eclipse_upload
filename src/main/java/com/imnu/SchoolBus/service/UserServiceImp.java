package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imnu.SchoolBus.mapper.UserMapper;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.pojo.UserExample;

public class UserServiceImp implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User LoginUser(String username, String password) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(userExample);
		return userList.isEmpty()?null:userList.get(0);
	}

	@Override
	public boolean ResUser(User user) {
//		int result = 0;
		int ResUser = userMapper.insertSelective(user);
//		if(ResUser>0) {
//			UserExample userExample = new UserExample();
//			userExample.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
//			List<User> userList = userMapper.selectByExample(userExample);
//			Integer userid = userList.get(0).getId();
//			Shopcar shopcar = new Shopcar();
//			shopcar.setUserId(userid);
//			result = shopcarMapper.insertSelective(shopcar);
//		}else {
//			return false;
//		}
		return ResUser>0?true:false;
	}

	//通过账号检查用户是否存在
	@Override
	public boolean ValidateUser(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?true:false;
	}
	
	//管理员显示用户
	@Override
	public List<User> getUserList(Integer pageNum) {
		List<User> userList = userMapper.selectByExample(null);
		return userList.isEmpty()?null:userList;
	}
	//通过账号、姓名、电话查找用户（模糊）
	@Override
	public List<User> getUserByData(User user) {
		UserExample userExample = new UserExample();
//			userExample.or().andUsernameLike("%"+user.getUsername()+"%");  or条件查询
		userExample.createCriteria().andUsernameLike("%"+user.getUsername()+"%")
		.andNameLike("%"+user.getName()+"%")
		.andPhoneLike("%"+user.getPhone()+"%");
		List<User> userList = userMapper.selectByExample(userExample);
		return userList.isEmpty()?null:userList;
	}
	//通过id修改用户
	@Override
	public boolean updateUserById(User user) {
		int result = userMapper.updateByPrimaryKeySelective(user); //传过来什么修改什么
												//updateByPrimaryKey(record);  全都修改
		return result>0?true:false;
	}
	//通过id查找用户
	@Override
	public User selectUserById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public User selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
		
		
}
