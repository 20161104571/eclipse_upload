package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Reply;

public interface ReplyService {

	void addReply(Reply reply);
	
	List<Reply> getReplyList();
	
	Reply findReplyById(int rid);
	
	int delReply(Integer rid);
}
