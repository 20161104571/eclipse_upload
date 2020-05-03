package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Notice;
@Transactional
public interface NoticeService {
	
	List<Notice> getNoticeList();
	
	void createNotice(Notice notice);
	
	int deleteNotice(Integer nId);
	
	Notice findNoticeById(int nId);
	
	void updateNotice(Notice notice);
	
	int countNotice(Integer nId);
	
}
