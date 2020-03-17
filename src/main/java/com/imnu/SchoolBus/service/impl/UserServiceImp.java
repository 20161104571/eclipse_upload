package com.imnu.SchoolBus.service.impl;

import java.util.List;

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
	
	/**
     * 用户注册，同时发送一封激活邮件
     * @param user
     */
    @Override
    public void register(User user) {
    	//String code = user.getCode();
        //System.out.println("code:"+code);
    	String code = "";
        String email = user.getEmail();
        System.out.println("email:"+email);
        String subject = "来自校车预约中心的激活邮件";
        //user/checkCode?code=xxx即是我们点击邮件链接之后进行更改状态的
        String context = "您的验证码是："+code+"请及时输入";
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

	@Override
	public int deleteUser(Integer id) {
		return userMapper.deleteUser(id);
	}

	@Override
	public List<User> getUserList() {
		List<User> list = userMapper.getUserList();
		return list;
	}

	@Override
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}

	@Override
	public void createUser(User user) {
		userMapper.createUser(user);
		
	}

	@Override
	public void registAdmin(User user) {
		userMapper.registAdmin(user);
		
	}

	@Override
	public User adminLogin(String username, String password) {
		User u = userMapper.adminLogin(username, password);
		if(u != null) {
			return u;
		}
		return null;
	}

	@Override
	public void updateMsg(User user) {
		userMapper.updateMsg(user);
	}
	
	@Override
	public User findUserByUsernameAndPwd(String username, String password) {
		return userMapper.findUserByUsernameAndPwd(username, password);
	}

	@Override
	public User changePwd(String username, String password, String newPassword) {
		User user = userMapper.findUserByUsernameAndPwd(username, newPassword);
		Integer id = user.getId();
		System.out.println(id);
		String oldpwd = user.getPassword();
		System.out.println(oldpwd);
		if(oldpwd.equals(password)) {
			User u = new User();
			u.setId(id);
			u.setPassword(newPassword);
			return userMapper.changePwd(username, newPassword);
		}
//		if(user != null) {
//			return user;
//		}
		return null;
		
	}

		
}
