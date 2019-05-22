package com.website.pubsub.service;

import java.util.List;

import com.website.pubsub.model.PostMessage;

public interface NotificationService {
	
	public void create(PostMessage post);
	
	public List<PostMessage> findbyId(int id);

}
