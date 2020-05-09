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
	
	@Select(value = "select * from comment order by cdate DESC")
	List<Comment> getCommList();
	
	@Insert(value = "insert into comment (cid,cname,cdate,ctitle,content,cflag) values (#{cid},#{cname},#{cdate},#{ctitle},#{content},1)")
	void addComment(Comment comment);
	
	@Update(value = "update comment set ctitle = #{ctitle},content = #{content} where cid = #{cid}")
	void updateComment(Comment comment);
	
	@Delete(value = "delete from comment,reply where (comment.cid=reply.rcid) comment.cid = #{cid}")
	int delComment(Integer cid);

	@Update(value = "update comment set cflag = 0 where cid = #{cid}") 
	void updateCommentFlag(Comment comment, int cid);
	
	@Select(value = "select * from comment where cid = #{cid}")
	Comment findCommentById(int cid);
	
	@Select(value = "select count(cid is not null) from comment where cflag = 1")
	int countComment(Integer comm);

	
}
