package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {

	private Integer c_id;
	
	private String c_userid;
	
	private Integer c_contentid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date c_createtime;
	
	private String c_content;
	
	private String c_otherid;
	
	private Integer c_state;

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getC_userid() {
		return c_userid;
	}

	public void setC_userid(String c_userid) {
		this.c_userid = c_userid;
	}

	public Integer getC_contentid() {
		return c_contentid;
	}

	public void setC_contentid(Integer c_contentid) {
		this.c_contentid = c_contentid;
	}

	public Date getC_createtime() {
		return c_createtime;
	}

	public void setC_createtime(Date c_createtime) {
		this.c_createtime = c_createtime;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_otherid() {
		return c_otherid;
	}

	public void setC_otherid(String c_otherid) {
		this.c_otherid = c_otherid;
	}

	public Integer getC_state() {
		return c_state;
	}

	public void setC_state(Integer c_state) {
		this.c_state = c_state;
	}

	@Override
	public String toString() {
		return "Comment [c_id=" + c_id + ", c_userid=" + c_userid + ", c_contentid=" + c_contentid + ", c_createtime="
				+ c_createtime + ", c_content=" + c_content + ", c_otherid=" + c_otherid + ", c_state=" + c_state + "]";
	}
}
