package com.website.pubsub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.website.pubsub.model.Channel;
import com.website.pubsub.model.CreateChannel;
import com.website.pubsub.model.User;
import com.website.pubsub.service.ChannelService;
import com.website.pubsub.service.UserService;

@RestController
public class ChannelController {
	
	@Autowired
	ChannelService channelService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/pubsub/createchannel", method = RequestMethod.POST)
	public int createchannel(@RequestBody CreateChannel channel) {
		
		Channel channel1=new Channel();
		String email=channel.getUser_email();
		channel1.setChannel_name(channel.getChannel_name());
		channel1.setChannel_info(channel.getChannel_info());
		User user=userService.findByEmail(email);
		channel1.setAdmin_name(user.getUserName());
		channel1.setUser(user);
		channelService.create(channel1);
		return 1;
	}

}
