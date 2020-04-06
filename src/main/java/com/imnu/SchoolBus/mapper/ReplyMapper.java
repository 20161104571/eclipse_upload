package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Reply;

@Mapper
public interface ReplyMapper {
	
	@Insert(value = "insert into reply (rid,rname,rdate,rcontent,rcname,rcid) values (#{rid},#{rname},#{rdate},#{rcontent},#{rcname},#{rcid})")
	void addReply(Reply reply);
	
	@Select(value = "select * from reply")
	List<Reply> getReplyList();
	
	@Select(value = "select * from reply where rid=#{rid}")
	Reply findReplyById(int rid);
	
	@Delete(value = "delete from reply where rid=#{rid}")
	int delReply(Integer rid);
}
