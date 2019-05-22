package com.website.pubsub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.pubsub.dao.DeleteDao;
import com.website.pubsub.model.Delete;
import com.website.pubsub.service.DeleteService;

@Service("deleteService")
@Transactional(rollbackFor=Exception.class)
public class DeleteServiceImpl implements DeleteService{
	
	@Autowired
	DeleteDao deleteDao;

	@Override
	public void create(Delete delete) {
		deleteDao.save(delete);
	}

}
