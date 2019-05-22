package com.website.pubsub.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.WebSocketSession;

import com.website.pubsub.model.Chat;
import com.website.pubsub.model.Message;
import com.website.pubsub.model.User;
import com.website.pubsub.service.ChannelService;
import com.website.pubsub.service.ChatService;
import com.website.pubsub.service.SubscriberService;

@RestController
public class ChatController {

	@Autowired
	ChatService chatService;
	
	@Autowired
	ChannelService channelService;
	
	@Autowired
	SubscriberService subscriberService;

	/*@RequestMapping(value = "/pubsub/chat/{user_id}/{subscriber_user_id}", method = RequestMethod.POST)
	public ModelAndView post(@RequestParam(value="messages",defaultValue="null?") String messages, @PathVariable("user_id") int user_id,
			@PathVariable("subscriber_user_id") int subscriber_user_id) {
		int id = user_id + subscriber_user_id;
		List<Chat> chat1=new ArrayList<Chat>();
		ModelAndView model = new ModelAndView("Chat");
		String check="null?";
		if (!messages.equals(check)) {
			
			Chat chat = new Chat();
			chat.setAdmin_id(user_id);
			chat.setSubscriber_id(subscriber_user_id);
			chat.setUnique_id(id);
            chat.setMessages(messages);
            chatService.create(chat);
		}
		chat1=chatService.findbyUnique_id(id);
		model.addObject("subscriber_user_id",subscriber_user_id);
		model.addObject("chat",chat1);
		return model;
	}*/
	
	@RequestMapping(value = "/pubsub/chat/{user_id}/{subscriber_user_id}", method = RequestMethod.GET)
	public List<Chat> get(@PathVariable("user_id") int user_id,
			@PathVariable("subscriber_user_id") int subscriber_user_id) {
		int id = user_id + subscriber_user_id;
		List<Chat> chat1=new ArrayList<Chat>();
		/*String check="null?";*/
			/*Chat chat = new Chat();
			chat.setAdmin_id(user_id);
			chat.setSubscriber_id(subscriber_user_id);
			chat.setUnique_id(id);
            chat.setMessages(messages);
            chatService.create(chat);*/
		
		chat1=chatService.findbyUnique_id(id);
		return chat1;
	}
	
	@RequestMapping(value="/pubsub/SubscriberList/{channel_id}",method=RequestMethod.GET)
	public List<Integer> subscriberList(@PathVariable("channel_id") int channel_id) {
		/*User user=new User();
		user=(User)session.getAttribute("user");
		int user_id=user.getUser_id();
		int channel_id=channelService.getChannelid(user_id);*/
		List<Integer> subscriber_ids=subscriberService.getUserid(channel_id);
		return subscriber_ids;
	}
	
	@MessageMapping("/user")
	@SendTo("/topic/user")
	public int getUser(Chat chat) {
		Chat chat1 = new Chat();
		chat1.setAdmin_id(chat.getAdmin_id());
		chat1.setSubscriber_id(chat.getSubscriber_id());
		chat1.setUnique_id(chat.getUnique_id());
        chat1.setMessages(chat.getMessages());
        chat1.setSender_name(chat.getSender_name());
        chatService.create(chat1);
		//return new Message(chat.getMessages(),chat.getUnique_id());
        return 1;
	}
	
}
