package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Reply {

	private Integer rid;
	
	private String rname;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date rdate;
	
	private String rcontent;
	
	private String rcname;
	
	private Integer rcid;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRcname() {
		return rcname;
	}

	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	public Integer getRcid() {
		return rcid;
	}

	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", rname=" + rname + ", rdate=" + rdate + ", rcontent=" + rcontent + ", rcname="
				+ rcname + ", rcid=" + rcid + "]";
	}

	
}
