package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Subs {
	
	private Integer oId;
	
	private Integer uId;
	
	private Integer tId;
	
	private String name;
	
	private String phone;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date time;
	
	private Integer place;
	
	private String trainNum;
	
	private String flag;
	

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

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Subs [oId=" + oId + ", uId=" + uId + ", tId=" + tId + ", name=" + name + ", phone=" + phone + ", time="
				+ time + ", place=" + place + ", trainNum=" + trainNum + ", flag=" + flag + "]";
	}


}
