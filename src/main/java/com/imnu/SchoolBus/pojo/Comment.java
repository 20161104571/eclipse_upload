package com.imnu.SchoolBus.pojo;

public class Comment {
	
	private Long comment_id;
	
	private Long user_id;
	
	private Long bolg_id;
	
	private Long reply_user_id;
	
	private Integer pid;
	
	private String comment_name;
	
	private String comment_msg;
	
	private String create_time;

	public Long getComment_id() {
		return comment_id;
	}

	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getBolg_id() {
		return bolg_id;
	}

	public void setBolg_id(Long bolg_id) {
		this.bolg_id = bolg_id;
	}

	public Long getReply_user_id() {
		return reply_user_id;
	}

	public void setReply_user_id(Long reply_user_id) {
		this.reply_user_id = reply_user_id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getComment_name() {
		return comment_name;
	}

	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}

	public String getComment_msg() {
		return comment_msg;
	}

	public void setComment_msg(String comment_msg) {
		this.comment_msg = comment_msg;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", user_id=" + user_id + ", bolg_id=" + bolg_id
				+ ", reply_user_id=" + reply_user_id + ", pid=" + pid + ", comment_name=" + comment_name
				+ ", comment_msg=" + comment_msg + ", create_time=" + create_time + "]";
	}


}
