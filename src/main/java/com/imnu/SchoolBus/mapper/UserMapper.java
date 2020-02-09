package com.imnu.SchoolBus.mapper;

import com.imnu.SchoolBus.pojo.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
//    long countByExample(UserExample example);
//
//    int deleteByExample(UserExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    List<User> selectByExample(UserExample example);
//
//    User selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
//
//    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
//
//	User checkCode(String code);
//
//	void updateUserStatus(User user);
//
//	void ResUser(User user);
//
//	User login(User user);
	
	@Insert(value = "insert into user (id,username,password,name,number,email,phone,status,code) values(#{id},#{username},#{password},#{name},#{number},#{email},#{phone},#{status},#{code})")
    void register(User user);

    /**
     * 根据激活码查询用户，之后再进行修改用户状态
     * @param code
     * @return
     */
	@Select(value = "select * from user where code = #{code}")
    User checkCode(String code);

    /**
     * 激活账户，修改用户状态为"1"
     * @param user
     */
	@Update(value = "update user set status=1,code=null where id=#{id}")
    void updateUserStatus(User user);

    /**
     * 登录
     * @param user
     * @return
     */
	@Select(value = "select * from user where username=#{username} and password=#{password} and status=1")
    User loginUser(User user);
    
	@Insert(value = "insert into user (id,username,password,name,number,email,phone,status,code) values(#{id},#{username},#{password},#{name},#{number},#{email},#{phone},#{status},#{code})")
	User email(User user);
}