package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.imnu.SchoolBus.pojo.Trip;


@Mapper
public interface TripMapper {
	
	@Insert(value = "insert into trip (tId,ccard,ctime,start,reqTime,seats,remain_seats) values (#{tId},#{ccard},#{ctime},#{start},#{reqTime},#{seats},#{seats})")
	void createTrip(Trip trip);
	
	@Delete(value = "delete from trip where tId = #{tId}")
	int deleteTrip(Integer tId);
	
	@Select(value = "select * from trip")
	List<Trip> getTripList();
	
	@Select(value = "select * from trip where ccard REGEXP #{arg0}")
	List<Trip> searchList(String search_input);
	
	@Select(value = "select * from trip where tId = #{tId}")
	Trip findSubsTripById(int tId);
	
	@Update(value = "update trip set remain_seats = remain_seats - 1")
	void updateSeats(Trip trip);
	
	@Update(value = "update trip set remain_seats = remain_seats + 1")
	void addSeats(Trip trip);
	
	@Select(value = "select * from trip between date_format(#{startTime},'yyyy-MM-dd') and date_format(#{endTime},'yyyy-MM-dd')")
	List<Trip> getTimeTripList();
}
