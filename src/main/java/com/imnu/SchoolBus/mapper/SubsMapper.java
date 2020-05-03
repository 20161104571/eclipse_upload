package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Subs;

@Mapper
public interface SubsMapper {
	
	@Select(value = "select * from subs")
	List<Subs> getOrderList();
	
	@Select(value = "select * from subs where uId = #{uId}")
	Subs findSubsById(Integer uId);
	
	@Insert(value = "insert into subs (oId,uId,tId,name,phone,time,date,place,trainNum) values(#{oId},#{uId},#{tId},#{name},#{phone},#{time},#{date},#{place},#{trainNum})")
	int addOrders(Subs subs);
	
	@Delete(value = "delete from subs where oId = #{oId}")
	int delOrder(Integer oId);

	@Select(value = "select count(oId is not null) from subs")
	int countNewOrder(Integer subs);
	
}
