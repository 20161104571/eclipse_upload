package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Trip;


@Mapper
public interface TripMapper {
	
	@Insert(value = "insert into trip (tId,ccard,ctime,start,reqTime) values (#{tId},#{ccard},#{ctime},#{start},#{reqTime})")
	void createTrip(Trip trip);
	
	@Delete(value = "delete from trip where tId = #{tId}")
	int deleteTrip(Integer tId);
	
	@Select(value = "select * from trip")
	List<Trip> getTripList();
	
	@Select(value = "select * from trip where ccard REGEXP #{arg0}")
	List<Trip> searchList(String search_input);
	
}