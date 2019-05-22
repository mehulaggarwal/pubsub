package com.website.pubsub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.pubsub.dao.ChatDao;
import com.website.pubsub.model.Chat;
import com.website.pubsub.service.ChatService;

@Service("chatService")
@Transactional(rollbackFor=Exception.class)
public class ChatServiceImpl implements ChatService{

	@Autowired
	ChatDao chatDao;
	
	@Override
	public void create(Chat chat) {
		chatDao.save(chat);
	}

	@Override
	public List<Chat> findbyUnique_id(int id) {
		return chatDao.findbyUnique_id(id);
	}

}
