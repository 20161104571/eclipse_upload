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
	private SubsMapper subsMapper;
	
	@Override
	public Subs findSubsById(Integer uId) {
		return subsMapper.findSubsById(uId);
	}

	@Override
	public List<Subs> getOrderList() {
		List<Subs> list = subsMapper.getOrderList();
		return list;
	}

	@Override
	public int addOrders(Subs subs) {
		int sub= subsMapper.addOrders(subs);
		return sub;
	}

	@Override
	public int delOrder(Integer oId) {
		return subsMapper.delOrder(oId);
	}

}
