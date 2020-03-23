package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Reply;

public interface ReplyService {

	List<Reply> selectReply(int contentId);

}
