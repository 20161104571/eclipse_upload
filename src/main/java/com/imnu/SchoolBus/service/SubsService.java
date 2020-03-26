package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Subs;

public interface SubsService {
	
	Subs findSubsById(int oId);
	
	List<Subs> getOrderList();
	
	int addOrders(Subs subs);
	
	int delOrder(Integer oId);
}
