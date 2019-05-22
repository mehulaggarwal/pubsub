package com.website.pubsub.service;

import java.util.List;

import com.website.pubsub.model.Subscriber;

public interface SubscriberService {
	
	public void create(Subscriber subscriber);
	
	public List<Subscriber> findbyUserid(int user_id);
	
	public List<Integer> getUserid(int channel_id);
	
	public void Unsusbcribe(int channel_id,int user_id);

}
