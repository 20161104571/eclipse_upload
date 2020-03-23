package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.imnu.SchoolBus.pojo.Comment;
import com.imnu.SchoolBus.pojo.Comment1;

@Mapper
public interface CommentMapper {

	@Select(value = "select comment_name,comment_msg,create_time from comment")
	List<Comment1> getCList();
	
	@Select(value = "select * from comment where c_id=#{c_id}")
	List<Comment> selectCommentById(int contentId);

}
