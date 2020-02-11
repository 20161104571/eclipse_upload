package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.imnu.SchoolBus.pojo.Driver;
//@Repository
@Mapper
//@Component("driverMapper")
public interface DriverMapper {

	@Insert(value = "insert into driver (d_id,dname,dnumber,dphone,diver_time) values (#{dId},#{dname},#{dnumber},#{dphone},#{diverTime})")
	void createDriver(Driver driver);
	
	@Update(value = "update driver set dname = #{dname},dnumber = #{dnumber},dphone = #{dphone},diver_time = #{diverTime} where d_id = #{dId}")
	int updateDriver(Driver driver);
	
	@Delete(value = "delete from driver where d_id = #{dId}")
	int deleteDriver(Integer dId);
	
	@Select(value = "select * from driver")
	List<Driver> getDriverList();
	
	@Select(value = "select * from driver where d_id = #{dId}")
	Driver findDriverById(int dId);
	
}