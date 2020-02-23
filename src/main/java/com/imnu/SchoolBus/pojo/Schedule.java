package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Schedule {
	
	private Integer sId;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date startTime;
	
	private Integer startPlace;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(Integer startPlace) {
		this.startPlace = startPlace;
	}

	@Override
	public String toString() {
		return "Schedule [sId=" + sId + ", startTime=" + startTime + ", startPlace=" + startPlace + "]";
	}
	
}
