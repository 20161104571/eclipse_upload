package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Subs;

@Mapper
public interface SubsMapper {
	
	@Select(value = "select * from subs")
	List<Subs> getOrderList();
	
	@Select(value = "selecr * from subs where oId = #{oId}")
	Subs findSubsById(int oId);
	
	@Insert(value = "INSERT INTO subs (oId,phone) values (#{oId},#{phone}) and INSERT INTO subs (uId,name,tId,time,place,trainNum) SELECT * FROM (SELECT id,name,tId,ctime,start,ccard FROM user JOIN trip) AS tb")
	Subs createOrder(Subs order);
	
	@Insert(value = "INSERT INTO subs(tId,time,place,trainNum) SELECT tId,ctime,start,ccard FROM trip")
	void createOrder2(Subs order);
	
}
