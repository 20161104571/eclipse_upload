package com.imnu.SchoolBus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.SubsMapper;
import com.imnu.SchoolBus.pojo.Subs;
import com.imnu.SchoolBus.service.SubsService;

@Service
@Transactional
public class SubsServiceImp implements SubsService{

	@Autowired
	private SubsMapper orderMapper;
	
	@Override
	public void createOrder(Subs order) {
		orderMapper.createOrder(order);
	}

	@Override
	public List<Subs> getOrderList() {
		List<Subs> list = orderMapper.getOrderList();
		return list;
	}

}
