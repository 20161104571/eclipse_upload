package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Reply {

	private Integer r_id;
	
	private String r_userid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date r_createtime;
	
	private String r_content;
	
	private String r_otherid;
	
	private String r_words;
	
	private Integer r_contentid;
	
	private Integer r_state;

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}

	public String getR_userid() {
		return r_userid;
	}

	public void setR_userid(String r_userid) {
		this.r_userid = r_userid;
	}

	public Date getR_createtime() {
		return r_createtime;
	}

	public void setR_createtime(Date r_createtime) {
		this.r_createtime = r_createtime;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_otherid() {
		return r_otherid;
	}

	public void setR_otherid(String r_otherid) {
		this.r_otherid = r_otherid;
	}

	public String getR_words() {
		return r_words;
	}

	public void setR_words(String r_words) {
		this.r_words = r_words;
	}

	public Integer getR_contentid() {
		return r_contentid;
	}

	public void setR_contentid(Integer r_contentid) {
		this.r_contentid = r_contentid;
	}

	public Integer getR_state() {
		return r_state;
	}

	public void setR_state(Integer r_state) {
		this.r_state = r_state;
	}

	@Override
	public String toString() {
		return "Reply [r_id=" + r_id + ", r_userid=" + r_userid + ", r_createtime=" + r_createtime + ", r_content="
				+ r_content + ", r_otherid=" + r_otherid + ", r_words=" + r_words + ", r_contentid=" + r_contentid
				+ ", r_state=" + r_state + "]";
	}
	
}
