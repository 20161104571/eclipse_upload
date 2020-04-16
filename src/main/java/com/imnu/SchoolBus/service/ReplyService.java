package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Reply;
@Transactional
public interface ReplyService {

	List<Reply> getReplyList();
	
	Reply findReplyById(int rid);
	
	int delReply(Integer rid);

	void saveReply(Reply reply);
	
}
