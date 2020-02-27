package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Trip {
	
	private Integer tId;
	
	private String ccard;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date ctime;
	
	private String start;
	
	private String reqTime;
	
	private Integer seats;
	
	private Integer remain_seats;
	
	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String getCcard() {
		return ccard;
	}

	public void setCcard(String ccard) {
		this.ccard = ccard;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
	
	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getRemain_seats() {
		return remain_seats;
	}

	public void setRemain_seats(Integer remain_seats) {
		this.remain_seats = remain_seats;
	}

	@Override
	public String toString() {
		return "Trip [tId=" + tId + ", ccard=" + ccard + ", ctime=" + ctime + ", start=" + start + ", reqTime="
				+ reqTime + ", seats=" + seats + ", remain_seats=" + remain_seats + "]";
	}

	

	
}
