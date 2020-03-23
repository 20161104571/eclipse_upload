package com.imnu.SchoolBus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.imnu.SchoolBus.mapper.ContentMapper;
import com.imnu.SchoolBus.pojo.Content;
import com.imnu.SchoolBus.service.ContentService;

@Service
@Transactional
public class ContentServiceImp implements ContentService{
	
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public Content selectContent(int contentId) {
		return null;
	}

}
