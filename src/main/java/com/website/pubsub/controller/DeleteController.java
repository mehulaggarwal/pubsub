package com.website.pubsub.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.website.pubsub.model.Delete;
import com.website.pubsub.model.PostMessage;
import com.website.pubsub.model.User;
import com.website.pubsub.service.DeleteService;
import com.website.pubsub.service.NotificationService;
import com.website.pubsub.service.UserService;

@RestController
public class DeleteController {

	@Autowired
	DeleteService deleteService;
	
	@Autowired
	UserService userService;

	@Autowired
	NotificationService notificationService;
	
	@RequestMapping(value = "/pubsub/deleteMessage/{channel_name}/{channel_id}/{Notification_id}",method=RequestMethod.POST)
	public List<PostMessage> deleteMessage(@PathVariable("channel_name") String channel_name,
			@PathVariable("channel_id") int channel_id, @PathVariable("Notification_id") int Notification_id,@RequestBody String userData) {

		Delete delete = new Delete();
		delete.setChannel_id(channel_id);
		delete.setNotification_id(Notification_id);
		User user=userService.findByEmail(userData);
		delete.setUser(user);
		System.out.println(userData);
		deleteService.create(delete);
		List<PostMessage> messages=new ArrayList<PostMessage>();
		messages=notificationService.findbyId(channel_id);
		// return new
		// ModelAndView("redirect:/pubsub/showMessages/{channel_name}/{channelid}");
		return messages;
	}

}
