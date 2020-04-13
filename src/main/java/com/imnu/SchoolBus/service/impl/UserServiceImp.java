package com.imnu.SchoolBus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.CommentMapper;
import com.imnu.SchoolBus.mapper.SubsMapper;
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
	private CommentMapper commentMapper;
	
	@Autowired
	private SubsMapper subsMapper;
	
	@Autowired
	private MailService mailService;
	
	
	/**
     * 用户注册，同时发送一封激活邮件
     * @param user
     */
    @Override
    public void register(User user) {
    	userMapper.register(user);
    	String code = user.getCode();
        System.out.println("code:"+code);
        String email = user.getEmail();
        System.out.println("email:"+email);
        String subject = "注册激活账号邮件";
        String context = "<a href=\"http://localhost:8080/schoolbus/checkCode?code="+code+"\">http://localhost:8080/schoolbus/checkCode?code="+code+"</a>";
        mailService.sendHtmlMail (user.getEmail(),subject,context);
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
	public int changePwd(int id, String newpassword) {
		User user = new User();
		user = userMapper.findUserById(id);
		user.setPassword(newpassword);
		int result = userMapper.changePwd(id, newpassword);
		return result;
	}

	@Override
	public User updateMsg(int id, String username, String name, String email, String phone) {
		User user = new User();
		user = userMapper.findUserById(id);
		user.setUsername(username);
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		int result = userMapper.updateMsg(id, username, name, email, phone);
		if(result > 0) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public List<User> getAdminList() {
		List<User> list = userMapper.getAdminList();
		return list;
	}

	@Override
	public int countUser(Integer count) {
		int c = userMapper.countUser(count);
		if(c>0) {
			return c;
		}
		return 0;
	}

	@Override
	public int countComment(Integer comm) {
		int com = commentMapper.countComment(comm);
		if(com>0) {
			return com;
		}
		return 0;
	}
	
	@Override
	public int countNewOrder(Integer subs) {
		int newor = subsMapper.countNewOrder(subs);
		if(newor>0) {
			return newor;
		}
		return 0;
	}

	@Override
	public List<User> getTeacherList() {
		List<User> list = userMapper.getTeacherList();
		return list;
	}

		
}
