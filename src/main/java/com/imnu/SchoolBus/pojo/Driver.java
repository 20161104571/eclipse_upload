package com.imnu.SchoolBus.pojo;

public class Driver {
    private Integer dId;

    private String dname;

    private String dnumber;

    private String dphone;

    private String diverTime;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDnumber() {
        return dnumber;
    }

    public void setDnumber(String dnumber) {
        this.dnumber = dnumber;
    }

    public String getDphone() {
        return dphone;
    }

    public void setDphone(String dphone) {
        this.dphone = dphone;
    }

    public String getDiverTime() {
        return diverTime;
    }

    public void setDiverTime(String diverTime) {
        this.diverTime = diverTime;
    }

	@Override
	public String toString() {
		return "Driver [dId=" + dId + ", dname=" + dname + ", dnumber=" + dnumber + ", dphone=" + dphone
				+ ", diverTime=" + diverTime + "]";
	}
    
    
    
}