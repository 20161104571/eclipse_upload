package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Subs;

@Mapper
public interface SubsMapper {
	
	//@Insert(value = "insert into subs (oId,uId,tId,name,phone,time,place,trainNum,flag) values (#{oId},null,null,#{name},#{phone},#{time},#{place},#{trainNum},#{flag}")
	//void createOrder(Subs order);
	
	@Select(value = "select * from subs")
	List<Subs> getOrderList();
	
	@Insert(value = "insert into subs (oId,uId,tId,name,phone,time,place,trainNum) values (#{oId},user.id,trip.tId,user.name,#{phone},trip.ctime,trip.start,trip.ccard")
	void createOrder(Subs order);
	
}
