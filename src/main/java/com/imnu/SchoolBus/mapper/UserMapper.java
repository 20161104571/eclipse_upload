package com.imnu.SchoolBus.mapper;

import com.imnu.SchoolBus.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	
	@Insert(value = "insert into user (id,username,password,name,number,email,phone,status,code) values(#{id},#{username},#{password},#{name},#{number},#{email},#{phone},#{status},#{code})")
    void register(User user);
	
	@Insert(value = "insert into user(id,username,password,name,number,email,phone,status) values(#{id},#{username},#{password},null,null,null,null,2)")
	void registAdmin(User user);

	@Select(value = "select * from user where code = #{code}")
    User checkCode(String code);
   
	@Update(value = "update user set status = 1,code = null where id=#{id}")
    void updateUserStatus(User user);

	@Select(value = "select * from user where number=#{number} and password=#{password} and status=1")
    User loginUser(User user);
    
	@Select(value = "select * from user where username=#{username} and password=#{password} and status=2")
	User adminLogin(String username, String password);
	
	@Insert(value = "insert into user (id,username,password,name,number,email,phone,status) values (#{id},#{username},123456,#{name},#{number},#{email},#{phone},1)")
    void createUser(User user);
	
	@Delete(value = "delete from user where id = #{id}")
	int deleteUser(Integer id);
	
	@Select(value = "select * from user where status = 1")
	List<User> getUserList();
	
	@Select(value = "select * from user where id = #{id}")
	User findUserById(int id);
	
	@Update(value = "update user set username = #{username},name = #{name},email = #{email},phone = #{phone} where id=#{id}")
	int updateMsg(int id, String username, String name, String email, String phone);
	
	@Update(value = "update user set password = #{newpassword} where id = #{id}")
	int changePwd(int id, String newpassword);

	@Select(value = "select * from user where status = 2")
	List<User> getAdminList();

	@Select(value = "SELECT COUNT(id) FROM user WHERE status = 1")
	int countUser(Integer count);
	
}