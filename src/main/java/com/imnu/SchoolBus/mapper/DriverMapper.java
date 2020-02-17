 package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.imnu.SchoolBus.pojo.Driver;

@Mapper
public interface DriverMapper {

	@Insert(value = "insert into driver (dId,dname,dnumber,dphone,driverTime) values (#{dId},#{dname},#{dnumber},#{dphone},#{driverTime})")
	void createDriver(Driver driver);
	
	@Update(value = "update driver set dname = #{dname},dnumber = #{dnumber},dphone = #{dphone},driverTime = #{driverTime} where dId = #{dId}")
	int updateDriver(Driver driver);
	
	@Delete(value = "delete from driver where dId = #{dId}")
	int deleteDriver(Integer dId);
	
	@Select(value = "select * from driver")
	List<Driver> getDriverList();
	
	@Select(value = "select * from driver where dId = #{dId}")
	Driver findDriverById(int dId);
	
}