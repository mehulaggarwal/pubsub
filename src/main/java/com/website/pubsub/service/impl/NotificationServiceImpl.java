package com.website.pubsub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.pubsub.dao.NotificationDao;
import com.website.pubsub.model.PostMessage;
import com.website.pubsub.service.NotificationService;

@Service("notificationService")
@Transactional(rollbackFor=Exception.class)
public class NotificationServiceImpl implements NotificationService{
	
	@Autowired
	NotificationDao notificationDao;

	@Override
	public void create(PostMessage post) {
		notificationDao.save(post);
		
	}

	@Override
	public List<PostMessage> findbyId(int id) {
		return notificationDao.findbyId(id);
	}

}
