package com.imnu.SchoolBus.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class Trip {
	
	private Integer tId;
	
	private String ccard;
	
	@DateTimeFormat(pattern = "HH:mm")
	private String ctime;
	
	private String start;
	
	private String reqTime;
	
	private Integer seats;
	
	private Integer remain_seats;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private String start_Date;

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

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
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

	public String getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}

	@Override
	public String toString() {
		return "Trip [tId=" + tId + ", ccard=" + ccard + ", ctime=" + ctime + ", start=" + start + ", reqTime="
				+ reqTime + ", seats=" + seats + ", remain_seats=" + remain_seats + ", start_Date=" + start_Date + "]";
	}

}
