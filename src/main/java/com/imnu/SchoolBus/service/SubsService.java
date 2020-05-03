package com.imnu.SchoolBus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.pojo.Subs;
@Transactional
public interface SubsService {
	
	Subs findSubsById(Integer uId);
	
	List<Subs> getOrderList();
	
	int addOrders(Subs subs);
	
	int delOrder(Integer oId);
}
