package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.imnu.SchoolBus.pojo.Drivers;
import com.imnu.SchoolBus.pojo.DriversExample;

@Repository
@Mapper
@Component("driversMapper")
public interface DriversMapper {
    long countByExample(DriversExample example);

    int deleteByExample(DriversExample example);

    int deleteByPrimaryKey(Integer dId);

    int insert(Drivers record);

    int insertSelective(Drivers record);

    List<Drivers> selectByExample(DriversExample example);

    Drivers selectByPrimaryKey(Integer dId);

    int updateByExampleSelective(@Param("record") Drivers record, @Param("example") DriversExample example);

    int updateByExample(@Param("record") Drivers record, @Param("example") DriversExample example);

    int updateByPrimaryKeySelective(Drivers record);

    int updateByPrimaryKey(Drivers record);
}