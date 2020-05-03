package com.imnu.SchoolBus.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class Subs {
	
	private Integer oId;
	
	private Integer uId;
	
	private Integer tId;
	
	private String name;
	
	private String phone;
	
	@DateTimeFormat(pattern = "HH:mm")
	private String time;
	
	private String date;
	
	private Integer place;
	
	private String trainNum;

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	@Override
	public String toString() {
		return "Subs [oId=" + oId + ", uId=" + uId + ", tId=" + tId + ", name=" + name + ", phone=" + phone + ", time="
				+ time + ", date=" + date + ", place=" + place + ", trainNum=" + trainNum + "]";
	}

}
