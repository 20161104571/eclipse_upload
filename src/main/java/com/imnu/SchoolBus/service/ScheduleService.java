package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Schedule;

@Transactional
public interface ScheduleService {
	
	List<Schedule> getScheduleList();
	
	void createSchedule(Schedule schedule);
	
	int deleteSchedule(Integer sId);
	
	Schedule findScheduleById(int sId);
	
	Schedule findScheduleByTime(String startTime);
	
	List<Schedule> getTimeList();
	
	List<Schedule> getTimeList2();
	
}
