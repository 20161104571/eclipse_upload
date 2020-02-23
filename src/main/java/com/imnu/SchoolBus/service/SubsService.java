package com.imnu.SchoolBus.service;

import java.util.List;

import com.imnu.SchoolBus.pojo.Subs;

public interface SubsService {
	
	void createOrder(Subs order);
	
	List<Subs> getOrderList();
}
