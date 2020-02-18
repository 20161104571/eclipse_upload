package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Notice {
	private Integer nId;
	
	private String title;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date releaseTime;
	
	private String noticeText;
	
	private String author;

	public Integer getnId() {
		return nId;
	}

	public void setnId(Integer nId) {
		this.nId = nId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getNoticeText() {
		return noticeText;
	}

	public void setNoticeText(String noticeText) {
		this.noticeText = noticeText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Notice [nId=" + nId + ", title=" + title + ", releaseTime=" + releaseTime + ", noticeText=" + noticeText
				+ ", author=" + author + "]";
	}
	
	
	
	
}
