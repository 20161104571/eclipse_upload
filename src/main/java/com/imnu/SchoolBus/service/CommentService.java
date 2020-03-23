package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Comment;
import com.imnu.SchoolBus.pojo.Comment1;

public interface CommentService {

	List<Comment1> getClist();

	List<Comment> selectCommentById(int contentId);
}
