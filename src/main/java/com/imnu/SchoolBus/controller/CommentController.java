package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imnu.SchoolBus.pojo.Comment;
import com.imnu.SchoolBus.pojo.Content;
import com.imnu.SchoolBus.pojo.Reply;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.CommentService;
import com.imnu.SchoolBus.service.ContentService;
import com.imnu.SchoolBus.service.ReplyService;
import com.imnu.SchoolBus.service.UserService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private ContentService contentService;
	
	 @RequestMapping("/comment")
	    public String comment(@RequestParam("contentId")int contentId, Model model){
	        System.out.println("id:"+contentId);
	        //获取该内容的所有信息
	        Content content=contentService.selectContent(contentId);
	        //获取该内容的用户信息
	        User user=userService.findUserById(content.getU_id());
	        //获取在该内容下的所有评论
	        List<Comment> commentList=commentService.selectCommentById(contentId);
	        //获取在该内容下的所有回复
	        List<Reply>replyList=replyService.selectReply(contentId);
	        model.addAttribute("content",content);
	        model.addAttribute("user",user);
	        model.addAttribute("commentList",commentList);
	        model.addAttribute("replyList",replyList);
	        return "showContent";

	    }
	
//	@RequestMapping("getCommentList")
//	public String getComment(Model model) {
//		List<Comment1> comments = commentService.getClist();
//		model.addAttribute("comments", comments);
//		return "admin/comment";
//	}
}
