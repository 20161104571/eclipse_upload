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
	
	@RequestMapping(value="getCommentList")
	public String commentList(Model model) {
		List<Comment> comment = commentService.getCommList();
		model.addAttribute("comment", comment);
		return "admin/comment";
	}
	
	@RequestMapping(value="getCommentsList")
	public String commentsList(Model model) {
		List<Comment> comment = commentService.getCommList();
		model.addAttribute("comments", comment);
		return "user/forum";
	}
	
	@RequestMapping(value="saveComment")
	public String createComm(Comment comment) {
		commentService.addComment(comment);
		return "redirect:/getCommentsList";
	}
	
	@RequestMapping(value="deleteComm")
	public String deleteComment(Integer cid) {
		commentService.delComment(cid);
		return "redirect:/getCommentsList";
	}
	
	@RequestMapping(value="toEditComm")
	public String toEdit(Model model,int cid) {
		Comment comment = commentService.findCommentById(cid);
		model.addAttribute("comment", comment);
		return "user/commedit";
	}
	
	@RequestMapping(value="editComm")
	public String edit(Comment comment) {
		commentService.updateComment(comment);
		return "redirect:/getCommentsList";
	}

}
