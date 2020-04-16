package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.imnu.SchoolBus.pojo.Comment;

@Transactional
public interface CommentService {

	List<Comment> getCommList();
	
	void addComment(Comment comment);
	
	void updateComment(Comment comment);
	
	int delComment(Integer cid);
	
	Comment findCommentById(int cid);
	
	void updateCommentFlag(Comment comment, int cid);
	
	public String getTime();

}
