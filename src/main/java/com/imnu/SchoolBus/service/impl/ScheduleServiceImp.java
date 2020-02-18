package com.imnu.SchoolBus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.ScheduleMapper;
import com.imnu.SchoolBus.pojo.Schedule;
import com.imnu.SchoolBus.service.ScheduleService;

@Service
@Transactional
public class ScheduleServiceImp implements ScheduleService{
	
	@Autowired
	private ScheduleMapper scheduleMapper;

	@Override
	public List<Schedule> getScheduleList() {
		List<Schedule> list = scheduleMapper.getScheduleList();
		return list;
	}

	@Override
	public void createSchedule(Schedule schedule) {
		scheduleMapper.createSchedule(schedule);
		
	}

	@Override
	public int deleteSchedule(Integer sId) {
		return scheduleMapper.deleteSchedule(sId);
	}

	@Override
	public Schedule findScheduleById(int sId) {
		return scheduleMapper.findScheduleById(sId);
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		scheduleMapper.updateSchedule(schedule);
		
	}

//	@Override
//	public List<Schedule> querySchedule() {
//		List<Schedule> list1 = scheduleMapper.querySchedule();
//		return list1;
//	}

}
