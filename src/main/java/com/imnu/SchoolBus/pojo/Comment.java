package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {

	private Integer cid;
	
	private String cname;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cdate;
	
	private String ctitle;
	
	private String content;
	
	private Integer pid;
	
	private Integer cflag;
	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCflag() {
		return cflag;
	}

	public void setCflag(Integer cflag) {
		this.cflag = cflag;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", cname=" + cname + ", cdate=" + cdate + ", ctitle=" + ctitle + ", content="
				+ content + ", pid=" + pid + ", cflag=" + cflag + "]";
	}

}
