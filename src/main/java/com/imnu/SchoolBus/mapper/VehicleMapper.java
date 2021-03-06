package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.imnu.SchoolBus.pojo.Vehicle;

@Mapper
public interface VehicleMapper {
	
	@Insert(value = "insert into vehicle (vId,card,Maintenance,insurance) values (#{vId},#{card},#{Maintenance},#{insurance})")
	void createVehicle(Vehicle vehicle);
	
	@Delete(value = "delete from vehicle where vId = #{vId}")
	int deleteVehicle(Integer vId);
	
	@Select(value = "select * from vehicle")
	List<Vehicle> getVehiclList();
	
	@Select(value = "select * from vehicle where vId = #{vId}")
	Vehicle findVehicleById(int vId);
	
	@Update(value = "update vehicle set card = #{card},Maintenance = #{Maintenance},insurance = #{insurance} where vId = #{vId}")
	void updateVehicle(Vehicle vehicle);
	
	@Select(value = "SELECT * FROM vehicle WHERE Maintenance=\"无维修\" AND insurance=\"有\"")
	List<Vehicle> getCardList();
}
