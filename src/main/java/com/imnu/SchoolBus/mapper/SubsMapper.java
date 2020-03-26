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
	
	@Select(value = "selecr * from subs where oId = #{oId}")
	Subs findSubsById(int oId);
	
	@Insert(value = "insert into subs (oId,uId,tId,name,phone,time,place,trainNum) values(#{oId},#{uId},#{tId},#{name},#{phone},#{time},#{place},#{trainNum})")
	int addOrders(Subs subs);
	
	@Delete(value = "delete from subs where oId = #{oId}")
	int delOrder(Integer oId);

	@Select(value = "select count(oId) from subs")
	int countNewOrder(Integer subs);
	
}
