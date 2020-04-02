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
	public List<Reply> getReplyList() {
		List<Reply> list = replyMapper.getReplyList();
		return list;
	}

	@Override
	public Reply findReplyById(int rid) {
		return replyMapper.findReplyById(rid);
	}

	@Override
	public int delReply(Integer rid) {
		return replyMapper.delReply(rid);
	}

	@Override
	public void saveReply(Reply reply) {
		replyMapper.addReply(reply);
	}

	@Override
	public List<Reply> findByReply() {
		return replyMapper.findByReply();
	}

}
