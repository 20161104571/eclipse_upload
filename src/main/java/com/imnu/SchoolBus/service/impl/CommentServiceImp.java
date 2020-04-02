package com.imnu.SchoolBus.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.CommentMapper;
import com.imnu.SchoolBus.pojo.Comment;
import com.imnu.SchoolBus.service.CommentService;

@Service
@Transactional
public class CommentServiceImp implements CommentService{
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> getCommList() {
		List<Comment> list = commentMapper.getCommList();
		return list;
	}

	@Override
	public void addComment(Comment comment) {
		commentMapper.addComment(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		commentMapper.updateComment(comment);
	}

	@Override
	public int delComment(Integer cid) {
		return commentMapper.delComment(cid);
	}

	@Override
	public Comment findCommentById(int cid) {
		return commentMapper.findCommentById(cid);
	}

	@Override
	public String getTime() {
		Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm ");
	    System.out.println("格式化输出：" + sdf.format(d));
	    return sdf.format(d);
	}

	@Override
	public List<Comment> findByComment() {
		return commentMapper.findByComment();
	}

}
