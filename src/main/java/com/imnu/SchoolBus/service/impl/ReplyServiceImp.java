package com.imnu.SchoolBus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.ReplyMapper;
import com.imnu.SchoolBus.pojo.Reply;
import com.imnu.SchoolBus.service.ReplyService;

@Service
@Transactional
public class ReplyServiceImp implements ReplyService{
	
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<Reply> selectReply(int contentId) {
		return null;
	}

}
