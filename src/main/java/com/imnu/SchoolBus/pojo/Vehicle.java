package com.imnu.SchoolBus.pojo;

public class Vehicle {
	
	private Integer vId;
	
	private String card;
	
	private String Maintenance;
	
	private String insurance;

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getMaintenance() {
		return Maintenance;
	}

	public void setMaintenance(String maintenance) {
		Maintenance = maintenance;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Vehicle [vId=" + vId + ", card=" + card + ", Maintenance=" + Maintenance + ", insurance=" + insurance
				+ "]";
	}
	
	
}
