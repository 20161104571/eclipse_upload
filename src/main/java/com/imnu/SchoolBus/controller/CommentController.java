package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public String commentList(Model model, String rtime, ModelMap modelMap,
							  @RequestParam(required = false,defaultValue = "1",value= "pageNum")Integer pageNum,
							  @RequestParam(defaultValue = "3",value = "pageSize")Integer pageSize) {
		List<Reply> reply = replyService.getReplyList();
		if(pageNum == null) {
			pageNum = 1;
		}
		if(pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);
		rtime = commentService.getTime();
		modelMap.addAttribute("rtime", rtime);
		model.addAttribute("reply", reply);
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<Comment> comment = commentService.getCommList();
			PageInfo<Comment> pageInfo = new PageInfo<Comment>(comment,pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/comment";
	}
	
	@RequestMapping(value="getCommentsList")
	public String commentsList(Model model, String ctime, ModelMap modelMap,
							   @RequestParam(required = false,defaultValue = "1",value= "pageNum")Integer pageNum,
			                   @RequestParam(defaultValue = "3",value = "pageSize")Integer pageSize) {
		List<Reply> reply = replyService.getReplyList();
		if(pageNum == null) {
			pageNum = 1;
		}
		if(pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);
		ctime = commentService.getTime();
		modelMap.addAttribute("ctime", ctime);
		model.addAttribute("replys", reply);
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<Comment> comment = commentService.getCommList();
			PageInfo<Comment> pageInfo = new PageInfo<Comment>(comment,pageSize);
			model.addAttribute("pageInfo", pageInfo);
		}finally {
			PageHelper.clearPage();
		}
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
	public String toEdit(Model model, int cid) {
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
	public String saveReply(Reply reply, int cid) {
		if(reply!=null) {
			Comment comment = commentService.findCommentById(cid);
			System.out.println(comment);
			commentService.updateCommentFlag(comment, cid);
			replyService.saveReply(reply);
			Integer rid = reply.getRcid();
			System.out.println(rid);
			return "redirect:getCommentList";
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="delReply")
	public String delReply(Integer rid) {
		replyService.delReply(rid);
		return "redirect:getCommentList";
	}
	
}
