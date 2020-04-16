package com.imnu.SchoolBus.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Schedule;
@Transactional
public interface ScheduleService {
	
	List<Schedule> getScheduleList();
	
	void createSchedule(Schedule schedule);
	
	int deleteSchedule(Integer sId);
	
	Schedule findScheduleById(int sId);
	
	Schedule findScheduleByTime(Date startTime);
	
}
