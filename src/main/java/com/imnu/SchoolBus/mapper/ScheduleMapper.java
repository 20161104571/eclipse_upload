package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Schedule;

@Mapper
public interface ScheduleMapper {
	
	@Select(value = "select * from schedule ORDER BY startTime")
	List<Schedule> getScheduleList();
	
	@Select(value = "select * from schedule where startPlace=\"1\" ORDER BY startTime")
	List<Schedule> getTimeList();
	
	@Select(value = "select * from schedule where startPlace=\"2\" ORDER BY startTime")
	List<Schedule> getTimeList2();
	
	@Insert(value = "insert into schedule (sId,startTime,endTime,startPlace) values (#{sId},#{startTime},#{endTime},#{startPlace})")
	void createSchedule(Schedule schedule);
	
	@Delete(value = "delete from schedule where sId = #{sId}")
	int deleteSchedule(Integer sId);
	
	@Select(value = "select * from schedule where sId = #{sId}")
	Schedule findScheduleById(int sId);
	
	@Select(value = "select * from schedule where startTime = #{startTime}")
	Schedule findScheduleByTime(String startTime);
	
}
