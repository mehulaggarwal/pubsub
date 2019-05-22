package com.website.pubsub.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.website.pubsub.model.Channel;
import com.website.pubsub.model.PostMessage;
import com.website.pubsub.model.Subscriber;
import com.website.pubsub.model.User;
import com.website.pubsub.service.ChannelService;
import com.website.pubsub.service.NotificationService;
import com.website.pubsub.service.SubscriberService;
import com.website.pubsub.service.UserService;

@RestController
public class SubscriberController {
	
	@Autowired
	SubscriberService subscriberService;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	ChannelService channelService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/pubsub/subscribeChannel/{channel_name}/{channel_id}",method=RequestMethod.POST)
	public int subscribe(@PathVariable("channel_name")String channelname,@PathVariable("channel_id") int channelid,@RequestBody String user_email){
		
		Subscriber person=new Subscriber();
		person.setChannel_id(channelid);
		person.setChannel_name(channelname);
		User user=userService.findByEmail(user_email);
		person.setUser(user);
		subscriberService.create(person);
		
		return 2;
	}

	@RequestMapping(value="/pubsub/UnsubscribeChannel/{channel_name}/{channel_id}",method=RequestMethod.POST)
	public int Unsubscribe(@PathVariable("channel_name")String channelname,@PathVariable("channel_id") int channelid,@RequestBody String user_email) {
		
		User user=userService.findByEmail(user_email);
		int user_id=user.getUser_id();
		subscriberService.Unsusbcribe(channelid, user_id);
		return 2;
	}
	
	@RequestMapping(value="/pubsub/showMessages/{channel_name}/{channel_id}",method=RequestMethod.GET)
	public List<PostMessage> getMessages(@PathVariable("channel_name")String channelname,@PathVariable("channel_id") int channelid) throws IOException
	{
		//ModelAndView model=new ModelAndView("messages");
		List<PostMessage> messages=new ArrayList<PostMessage>();
		messages=notificationService.findbyId(channelid);
		/*for(PostMessage message:messages)
		{
		  if(message.getUploaded_file()!=null)
		  {
			  String filePath=message.getUploaded_file();
			  File file=new File(filePath);
			  String mimeType = URLConnection.guessContentTypeFromName("Screenshot (17).png");
			  if (mimeType == null) {
					//unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/octet-stream";
				}
				response.setContentType(mimeType);
				*//**
				 * Here we have mentioned it to show inline
				 *//*
				response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + "hey.png" + "\""));

				 //Here we have mentioned it to show as attachment
				 //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());
				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
				FileCopyUtils.copy(inputStream, response.getOutputStream());
				
				response.getOutputStream().flush();
				response.getOutputStream().close();
				
				
		  }
		}*/
		/*model.addObject("messages",messages);
		Channel channel=channelService.findbychannel_id(channelid);
		User user=channel.getUser();
		int user_id=user.getUser_id();
		int subscriber_user_id=(int)session.getAttribute("subscriber_user_id");
		model.addObject("subscriber_user_id",subscriber_user_id);
		model.addObject("user_id",user_id);
		model.addObject("channel_id",channelid);
		return model;*/
		return messages;
	}
	
	@RequestMapping(value="/pubsub/isItSubscribed",method=RequestMethod.POST)
	public List<Subscriber> isItSubscribed(@RequestBody String user_email)
	{
		User user=userService.findByEmail(user_email);
		List<Subscriber> subscribedList=new ArrayList<Subscriber>();
		subscribedList=subscriberService.findbyUserid(user.getUser_id());
		return subscribedList;
	}
	
	@RequestMapping(value="/pubsub/getAdminId",method=RequestMethod.POST)
	public int getAdminId(@RequestBody int channel_id) {
		Channel channel=channelService.findbychannel_id(channel_id);
	    return channel.getUser().getUser_id();
	}
	
	@RequestMapping(value="/pubsub/getSubscriberId",method=RequestMethod.POST)
	public int getSubscriberId(@RequestBody String user_email) {
		User user=userService.findByEmail(user_email);
		return user.getUser_id();
	}

}
