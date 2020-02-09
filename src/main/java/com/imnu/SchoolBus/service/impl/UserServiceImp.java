package com.imnu.SchoolBus.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.UserMapper;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.MailService;
import com.imnu.SchoolBus.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MailService mailService;
	/*
	 * @Override public User LoginUser(String username, String password) {
	 * UserExample userExample = new UserExample();
	 * userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(
	 * password); List<User> userList = userMapper.selectByExample(userExample);
	 * return userList.isEmpty()?null:userList.get(0); }
	 */

	/**
     * 用户注册，同时发送一封激活邮件
     * @param user
     */
    @Override
    public void register(User user) {
    	String code = user.getCode();
        System.out.println("code:"+code);
        String email = user.getEmail();
        System.out.println("email:"+email);
        String subject = "来自校车预约中心的激活邮件";
        //user/checkCode?code=xxx即是我们点击邮件链接之后进行更改状态的
        String context = "<a href=\"http://localhost:8080/schoolbus/loginres/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendHtmlMail (user.getEmail(),subject,context);
    	userMapper.register(user);
        
    }

    /**
     * 根据激活码code进行查询用户，之后再进行修改状态
     * @param code
     * @return
     */
    @Override
    public User checkCode(String code) {

        return userMapper.checkCode(code);
    }

    /**
     * 激活账户，修改用户状态
     * @param user
     */
    @Override
    public void updateUserStatus(User user) {
    	userMapper.updateUserStatus(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User loginUser(User user) {
        User user1 = userMapper.loginUser(user);
        if (user1 !=null){
            return user1;
        }
        return null;
    }


//	@Override
//	public void email(User user) {
//		String code = user.getCode();
//        System.out.println("code:"+code);
//        String email = user.getEmail();
//        System.out.println("email:"+email);
//        String subject = "来自校车预约中心的激活邮件";
//        //user/checkCode?code=xxx即是我们点击邮件链接之后进行更改状态的
//        String context = "<a href=\"http://localhost:8080/schoolbus/loginres/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
//        //发送激活邮件
//        mailService.sendHtmlMail (user.getEmail(),subject,context);
//	}
	
//	@Override
//	public User login(User user) {
//		UserExample example = new UserExample();
//		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
//		List<User> list = userMapper.selectByExample(example);
//		return list.isEmpty()?null:list.get(0);
//	}
//	
//	
//
//	@Override
//	public boolean ResUser(User user) {
////		user.setId(UUID.randomUUID().toString());
//		
//		int ResUser = userMapper.insertSelective(user);
//		return ResUser>0?true:false;
//		//userMapper.insertSelective(user);
//	}
	

	//通过账号检查用户是否存在
//	@Override
//	public boolean ValidateUser(User user) {
//		UserExample example = new UserExample();
//		example.createCriteria().andUsernameEqualTo(user.getUsername());
//		List<User> userList = userMapper.selectByExample(example);
//		return userList.isEmpty()?true:false;
//	}
//	
//	
//	//通过账号、姓名、电话查找用户（模糊）
//	@Override
//	public List<User> getUserByData(User user) {
//		UserExample userExample = new UserExample();
////			userExample.or().andUsernameLike("%"+user.getUsername()+"%");  or条件查询
//		userExample.createCriteria().andUsernameLike("%"+user.getUsername()+"%")
//		.andNameLike("%"+user.getName()+"%")
//		.andPhoneLike("%"+user.getPhone()+"%");
//		List<User> userList = userMapper.selectByExample(userExample);
//		return userList.isEmpty()?null:userList;
//	}
//	//通过id修改用户
//	@Override
//	public boolean updateUserById(User user) {
//		int result = userMapper.updateByPrimaryKeySelective(user); //传过来什么修改什么
//												//updateByPrimaryKey(record);  全都修改
//		return result>0?true:false;
//	}
//	//通过id查找用户
//	@Override
//	public User selectUserById(int id) {
//		User user = userMapper.selectByPrimaryKey(id);
//		return user;
//	}
//
//	@Override
//	public boolean findUserByUserName(String username) {
//		UserExample example = new UserExample();
//		example.createCriteria().andUsernameEqualTo(username);
//		List<User> list = userMapper.selectByExample(example);
//		return list.size()==0?false:true;
//	}
//	
//	//管理员显示用户
//		@Override
//		public List<User> getUserList(Integer pageNum) {
//			List<User> userList = userMapper.selectByExample(null);
//			return userList.isEmpty()?null:userList;
//		}
//		
//	@Override
//	public List<User> getUserList() {
//		UserExample example = new UserExample();
//		List<User> list = userMapper.selectByExample(example);
//		return list;
//	}
//
//	@Override
//	public List<User> findUserByPage(int page) {
//		return userMapper.selectByExample(new UserExample());
//	}

	

	
		
		
}
