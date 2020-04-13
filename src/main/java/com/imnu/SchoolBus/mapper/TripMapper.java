package com.imnu.SchoolBus.mapper;

import java.util.Date;
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
	
	@Select(value = "select * from trip where ccard like CONCAT('%',#{search_input},'%') is not null")
	List<Trip> searchList(String search_input);
	
	@Select(value = "select * from trip where tId = #{tId}")
	Trip findSubsTripById(int tId);
	
	@Update(value = "update trip set remain_seats = remain_seats - 1 where tId=#{tId}")
	void updateSeats(int tId, Trip trip);
	
	@Update(value = "update trip set remain_seats = remain_seats + 1 where tId=#{tId}")
	void addSeats(int tId, Trip trip);
	
	@Select(value = "select * from trip where ctime = #{ctime}")
	Trip findTripsByTime(Date ctime);
	
	@Select(value = "select ctime from trip where ctime between #{startTime} and #{endTime}")
	Trip findTripByTime(Date startTime, Date endTime);
	//@Select(value = "select * from trip between date_format(#{schedule.startTime},'yyyy-MM-dd') and date_format(#{schedule.endTime},'yyyy-MM-dd')")
	@Select(value = "select * from trip where ctime between #{startTime} and #{endTime}")
	//@Select(value = "select * from trip where ctime >= #{startTime} and ctime <= #{endTime}")
	List<Trip> getTimeTripList(Date startTime, Date endTime);

}
