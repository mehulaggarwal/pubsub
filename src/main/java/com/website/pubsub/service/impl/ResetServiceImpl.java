package com.website.pubsub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.pubsub.dao.ResetDao;
import com.website.pubsub.model.Reset;
import com.website.pubsub.service.ResetService;

@Service("resetService")
@Transactional(rollbackFor=Exception.class)
public class ResetServiceImpl implements ResetService{
	
	@Autowired
	ResetDao resetDao;

	@Override
	public void create(Reset reset) {
		resetDao.save(reset);
		
	}

	@Override
	public Reset findByUrl(String url) {
		return resetDao.findByUrl(url);
	}
	
	

}
