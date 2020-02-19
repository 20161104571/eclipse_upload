package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Schedule;

public interface ScheduleService {
	
	List<Schedule> getScheduleList();
	
	void createSchedule(Schedule schedule);
	
	int deleteSchedule(Integer sId);
	
	Schedule findScheduleById(int sId);
	
	List<Schedule> querySchedule();
}
