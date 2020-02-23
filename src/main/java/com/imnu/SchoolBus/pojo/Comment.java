package com.imnu.SchoolBus.pojo;

public class Comment {
	
	private Long commentId;

    private Long userId;

    private Long blogId;

    private Long replyUserId;

    private Long pid;

    private String commentMeg;

    private String creatTime;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public Long getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(Long replyUserId) {
		this.replyUserId = replyUserId;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getCommentMeg() {
		return commentMeg;
	}

	public void setCommentMeg(String commentMeg) {
		this.commentMeg = commentMeg;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", blogId=" + blogId + ", replyUserId="
				+ replyUserId + ", pid=" + pid + ", commentMeg=" + commentMeg + ", creatTime=" + creatTime + "]";
	}
    
    
}
