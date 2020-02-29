package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Comment;
import com.imnu.SchoolBus.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("getCommentList")
	public String getComment(Model model) {
		List<Comment> comments = commentService.getClist();
		model.addAttribute("comments", comments);
		return "admin/comment";
	}
}
