package com.imnu.SchoolBus.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Order {
	
	private Integer oId;
	
	private String phone;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date time;
	
	private String trainNum;

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
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

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	@Override
	public String toString() {
		return "Order [oId=" + oId + ", phone=" + phone + ", time=" + time + ", trainNum=" + trainNum + "]";
	}
	
	
}
