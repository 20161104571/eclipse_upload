package com.imnu.SchoolBus.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class Schedule {
	
	private Integer sId;
	
	@DateTimeFormat(pattern = "HH:mm")
	private String startTime;
	
	@DateTimeFormat(pattern = "HH:mm")
	private String endTime;
	
	private Integer startPlace;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(Integer startPlace) {
		this.startPlace = startPlace;
	}

	@Override
	public String toString() {
		return "Schedule [sId=" + sId + ", startTime=" + startTime + ", endTime=" + endTime + ", startPlace="
				+ startPlace + "]";
	}


	
}
