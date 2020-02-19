package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Schedule;

@Mapper
public interface ScheduleMapper {
	
	@Select(value = "select * from schedule")
	List<Schedule> getScheduleList();
	
	@Insert(value = "insert into schedule (sId,startTime,startPlace) values (#{sId},#{startTime},#{startPlace})")
	void createSchedule(Schedule schedule);
	
	@Delete(value = "delete from schedule where sId = #{sId}")
	int deleteSchedule(Integer sId);
	
	@Select(value = "select * from schedule where sId = #{sId}")
	Schedule findScheduleById(int sId);
	
	@Select(value = "select * from schedule where startPlace like '%#{startPlace}%'")
	List<Schedule> querySchedule();
}
