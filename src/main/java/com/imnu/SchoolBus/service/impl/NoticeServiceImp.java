package com.imnu.SchoolBus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.NoticeMapper;
import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.service.NoticeService;

@Service
@Transactional
public class NoticeServiceImp implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> getNoticeList() {
		List<Notice> list = noticeMapper.getNoticeList();
		return list;
	}

	@Override
	public void createNotice(Notice notice) {
		noticeMapper.createNotice(notice);
		
	}

	@Override
	public int deleteNotice(Integer nId) {
		return noticeMapper.deleteNotice(nId);
	}

	@Override
	public Notice findNoticeById(int nId) {
		return noticeMapper.findNoticeById(nId);
	}

	@Override
	public void updateNotice(Notice notice) {
		noticeMapper.updateNotice(notice);
	}

	@Override
	public int countNotice(Integer nId) {
		int n = noticeMapper.countNotice(nId);
		if(n>0) {
			return n;
		}
		return 0;
	}


}
