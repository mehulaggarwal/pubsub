package com.website.pubsub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.pubsub.dao.SubscriberDao;
import com.website.pubsub.model.Subscriber;
import com.website.pubsub.service.SubscriberService;

@Service("subscriberService")
@Transactional(rollbackFor=Exception.class)
public class SubscriberServiceImpl implements SubscriberService{

	@Autowired
	SubscriberDao subscriberDao;
	
	@Override
	public void create(Subscriber subscriber) {
		subscriberDao.save(subscriber);
		
	}

	@Override
	public List<Subscriber> findbyUserid(int user_id) {
		return subscriberDao.findbyUserid(user_id);
	}

	@Override
	public List<Integer> getUserid(int channel_id) {
		return subscriberDao.getUserid(channel_id);
	}

	@Override
	public void Unsusbcribe(int channel_id, int user_id) {
		 subscriberDao.Unsusbcribe(channel_id, user_id);
		
	}

}
