package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imnu.SchoolBus.pojo.Comment;
import com.imnu.SchoolBus.pojo.Reply;
import com.imnu.SchoolBus.service.CommentService;
import com.imnu.SchoolBus.service.ReplyService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="getCommentList")
	public String commentList(Model model) {
		List<Comment> comment = commentService.getCommList();
		model.addAttribute("comment", comment);
		return "admin/comment";
	}
	
	@RequestMapping(value="getCommentsList")
	public String commentsList(Model model, String ctime, ModelMap modelMap) {
		List<Comment> comment = commentService.getCommList();
		ctime = commentService.getTime();
		modelMap.addAttribute("ctime", ctime);
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
	
	@RequestMapping(value="saveReply")
	public String saveReply(Reply reply) {
		if(reply!=null) {
			replyService.saveReply(reply);
			Integer rid = reply.getRcid();
			System.out.println(rid);
			return "redirect:toArticleView.do?rid=\"+rid";
		}else {
			return null;
		}
	}
	
	private List<Comment> lcList;
	private List<Reply> lrList;
	
	@RequestMapping(value="toArticleView")
	public String toArticleView(@RequestParam int rid, Model model) {
		lcList = commentService.findByComment();
		model.addAttribute("lcList", lcList);
		lrList = replyService.findByReply();
		model.addAttribute("lrList", lrList);
		return null;
	}

}
