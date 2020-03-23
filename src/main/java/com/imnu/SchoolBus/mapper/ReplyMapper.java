package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Reply;

@Mapper
public interface ReplyMapper {
	
	@Select(value = "select * from reply where ")
	List<Reply> selectReply(int contentId);

}
