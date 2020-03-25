package com.imnu.SchoolBus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.imnu.SchoolBus.pojo.Comment;

@Mapper
public interface CommentMapper {
	
	@Select(value = "select * from comment")
	List<Comment> getCommList();
	
	@Insert(value = "insert into comment (cid,cname,cdate,ctitle,content,pid) values (#{cid},#{cname},#{cdate},#{ctitle},#{content},#{cid})")
	void addComment(Comment comment);
	
	@Update(value = "update comment set ctitle = #{ctitle},content = #{content} where cid = #{cid}")
	void updateComment(Comment comment);
	
	@Delete(value = "delete from comment where cid = #{cid}")
	int delComment(Integer cid);
	
	@Select(value = "select * from comment where cid = #{cid}")
	Comment findCommentById(int cid);
	
	
}
