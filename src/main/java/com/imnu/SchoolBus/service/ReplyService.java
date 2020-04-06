package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Reply;

public interface ReplyService {

	List<Reply> getReplyList();
	
	Reply findReplyById(int rid);
	
	int delReply(Integer rid);

	void saveReply(Reply reply);
	
}
