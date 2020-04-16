package com.imnu.SchoolBus.pojo;

public class Sel_meg {

	private Integer stu_id;
	
	private String stu_name;
	
	private String stu_num;
	
	private String stu_sex;

	public Integer getStu_id() {
		return stu_id;
	}

	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	@Override
	public String toString() {
		return "Sel_meg [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_num=" + stu_num + ", stu_sex=" + stu_sex
				+ "]";
	}

	
}
