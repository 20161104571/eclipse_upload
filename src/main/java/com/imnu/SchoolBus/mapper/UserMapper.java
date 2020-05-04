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
	
	@Insert(value = "insert into user(id,username,password,name,number,email,phone,status) values(#{id},#{username},#{password},#{name},null,null,null,2)")
	void registAdmin(User user);

	@Select(value = "select * from user where code = #{code}")
    User checkCode(String code);
   
	@Update(value = "update user set status = 1,code = null where id=#{id}")
    void updateUserStatus(User user);

	@Select(value = "select * from user where number=#{number} and password=#{password}")
    User loginUser(User user);
    
	@Select(value = "select * from user where username=#{username} and password=#{password} and status=2")
	User adminLogin(String username, String password);
	
	@Insert(value = "insert into user (id,username,password,name,number,email,phone,status) values (#{id},#{username},123456,#{name},#{number},#{email},#{phone},1)")
    void createUser(User user);
	
	@Delete(value = "delete from user where id = #{id}")
	int deleteUser(Integer id);
	
	@Select(value = "select * from user where status = 1")
	List<User> getUserList();
	
	@Select(value = "select * from user where status = 3 order by number ASC")
	List<User> getTeacherList();
	
	@Select(value = "select * from user where id = #{id}")
	User findUserById(int id);
	
	@Select(value = "select * from user where password = #{password} and id = #{id}")
	List<User> findUserPwd(int id, String password);
	
	@Select(value = "select * from user where username = #{username}")
	List<User> findUserByUsername(String username);
	
	@Select(value = "select * from user where number = #{number}")
	List<User> findStuByNumber(String number);
	
	@Select(value = "select * from sel_meg where stu_name = #{stuname} and stu_num = #{stunum}")
	List<User> findStuByNameAndNum(String stuname, String stunum);
	
	@Select(value = "select * from user where phone = #{phone}")
	List<User> findUserByPhone(String phone);
	
	@Select(value = "select * from user where email = #{email}")
	List<User> findUserByEmail(String email);
	
	@Select(value = "select * from user where number=#{number} and password=#{password} and status=2")
	List<User> checkUser(User user);
	
	@Update(value = "update user set username = #{username},name = #{name},email = #{email},phone = #{phone} where id=#{id}")
	int updateMsg(int id, String username, String name, String email, String phone);
	
	@Update(value = "update user set password = #{newpassword} where id = #{id}")
	int changePwd(int id, String newpassword);

	@Select(value = "SELECT COUNT(id is not null) FROM user WHERE status = 1")
	int countUser(Integer count);
	
	@Select(value = "SELECT COUNT(id is not null) FROM user WHERE status = 3")
	int countTeUser(Integer counts);
	
	@Insert(value = "insert into user (id,username,password,name,number,email,phone,status) values (#{id},#{username},#{password},#{name},#{number},#{email},#{phone},#{status})")
	int insertTeachersByExcel(User user);
	
	@Update(value = "update user set username = #{username},name = #{name},email = #{email},phone = #{phone} where number = #{number}")
	int updateByNum(User user);
	
	@Select(value = "select * from user where number = #{number}")
	List<User> selectByNumber(String number);
}