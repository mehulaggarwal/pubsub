package com.website.pubsub.service;

import java.util.List;

import com.website.pubsub.model.Chat;

public interface ChatService {
  
	public void create(Chat chat);
	
	public List<Chat> findbyUnique_id(int id);
	
}
