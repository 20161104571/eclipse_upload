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
	
	@Insert(value = "insert into trip (tId,ccard,ctime,start,reqTime,seats,remain_seats,start_Date) values (#{tId},#{ccard},#{ctime},#{start},#{reqTime},#{seats},#{seats},#{start_Date})")
	void createTrip(Trip trip);
	
	@Delete(value = "delete from trip where tId = #{tId}")
	int deleteTrip(Integer tId);
	
	@Select(value = "select * from trip where start_Date >= #{nowDate}")
	List<Trip> getTripList(String nowDate);
	
	@Select(value = "select * from trip order by start_Date DESC")
	List<Trip> getTripsList();
	
	@Select(value = "select * from trip where ccard like CONCAT('%',#{search_input},'%')")
	List<Trip> searchList(String search_input);
	
	@Select(value = "select * from trip where tId = #{tId}")
	Trip findSubsTripById(int tId);
	
	@Update(value = "update trip set remain_seats = remain_seats - 1 where tId=#{tId}")
	void updateSeats(int tId, Trip trip);
	
	@Update(value = "update trip set remain_seats = remain_seats + 1 where tId=#{tId}")
	void addSeats(int tId, Trip trip);
	
	@Select(value = "select * from trip where ctime = #{ctime}")
	Trip findTripsByTime(String ctime);
	
	@Select(value = "select * from trip where start like concat('%',#{testInputOne},'%') and start_Date like concat('%',#{testInputTwo},'%')")
	List<Trip> findResultByStartAndDate(String testInputOne, String testInputTwo);
	
	@Select(value = "select * from trip where start = #{start} and start_Date >= #{nowDate} and ctime between #{startTime} and #{endTime}")
	List<Trip> getTimeTripList(Integer start, String nowDate, String startTime, String endTime);
	
}
