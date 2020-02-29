package com.imnu.SchoolBus.service.impl;

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
	public List<Comment> getClist() {
		List<Comment> list = commentMapper.getCList();
		return list;
	}

}