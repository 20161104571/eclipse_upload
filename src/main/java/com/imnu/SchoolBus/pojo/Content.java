package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Content {

	private Integer contentid;
	
	private Integer u_id;
	
	private String content_words;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date content_createtime;

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getContent_words() {
		return content_words;
	}

	public void setContent_words(String content_words) {
		this.content_words = content_words;
	}

	public Date getContent_createtime() {
		return content_createtime;
	}

	public void setContent_createtime(Date content_createtime) {
		this.content_createtime = content_createtime;
	}

	@Override
	public String toString() {
		return "Content [contentid=" + contentid + ", u_id=" + u_id + ", content_words=" + content_words
				+ ", content_createtime=" + content_createtime + "]";
	}

}
