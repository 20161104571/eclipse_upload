package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Subs;

public interface SubsService {
	
	Subs createOrder(Subs order);
	
	Subs findSubsById(int oId);
	
	List<Subs> getOrderList();
	
	void createOrder2(Subs order);
}
