package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Reply {

	private Integer rid;
	
	private String rname;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rdate;
	
	private String rcontent;
	
	private Integer rpid;

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

	public Integer getRpid() {
		return rpid;
	}

	public void setRpid(Integer rpid) {
		this.rpid = rpid;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", rname=" + rname + ", rdate=" + rdate + ", rcontent=" + rcontent + ", rpid="
				+ rpid + "]";
	}
	
}
