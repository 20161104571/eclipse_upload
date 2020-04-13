package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="getNoticeList")
	public String noticeList(Model model) {
		List<Notice> notices = noticeService.getNoticeList();
		model.addAttribute("notices", notices);
		return "admin/notice-list";
	}
	
	@RequestMapping(value="saveNotice")
	public String createNotice(Notice notice) {
		noticeService.createNotice(notice);
		return "redirect:/getNoticeList";
	}
	
	@RequestMapping(value="deleteNotice")
	public String deleteNotice(Integer nId) {
		noticeService.deleteNotice(nId);
		return "redirect:/getNoticeList";
	}
	
	@RequestMapping(value="toEditNotice")
	public String updateNotice(Model model,int nId) {
		Notice notice = noticeService.findNoticeById(nId);
		model.addAttribute("notice", notice);
		return "admin/notice-edit";
	}
	
	@RequestMapping(value="editNotice")
	public String edit(Notice notice) {
		noticeService.updateNotice(notice);
		return "redirect:/getNoticeList";
	}
	
	@RequestMapping(value="shownotice")
	public String showNotice(Model model) {
		List<Notice> notices = noticeService.getNoticeList();
		model.addAttribute("notices", notices);
		return "user/notice";
	}
	
	@RequestMapping(value="getContent")
	public String getContent(Model model,int nId) {
		Notice notice = noticeService.findNoticeById(nId);
		model.addAttribute("notice", notice);
		return "user/content";
	}
}
