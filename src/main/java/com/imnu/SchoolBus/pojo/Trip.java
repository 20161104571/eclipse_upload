package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Trip {
	
	private Integer tId;
	
	private String ccard;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date ctime;
	
	private String start;
	
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

	@Override
	public String toString() {
		return "Trip [tId=" + tId + ", ccard=" + ccard + ", ctime=" + ctime + ", start=" + start + "]";
	}

}
