package com.website.pubsub.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.website.pubsub.model.Retain;
import com.website.pubsub.model.*;
import com.website.pubsub.service.ChannelService;
import com.website.pubsub.service.NotificationService;
import com.website.pubsub.service.UserService;


@RestController
public class NotificationController {
	
	private static final String UPLOAD_DIRECTORY = "/images";

	@Autowired
	NotificationService notificationService;

	@Autowired
	ChannelService channelService;

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/pubsub/PostMessage/{channel_name}/{channel_id}", method=RequestMethod.POST)
	public int PostMessage(@PathVariable("channel_name") String channel_name,
			@PathVariable("channel_id") int channel_id,@Valid MessageUser message_user) {
		
		/*PostMessage post = new PostMessage();
		post.setChannel_name(channel_name);
		post.setChannel_id(channel_id);
		post.setMessage(message_user.getMessage());
		String user_email=message_user.getUser_email();*/
		System.out.println("hello");
	    System.out.println(message_user.getFile().getOriginalFilename());
		/*User user=new User();
		user=userService.findByEmail(user_email);
		post.setUser(user);
		notificationService.create(post);*/
		return 1;
	}

	/*@RequestMapping(value = "/pubsub/PostMessage/{channel_name}/{channel_id}", method = RequestMethod.GET)
	public ModelAndView message(@RequestParam("message") String message, @RequestParam MultipartFile file,
			HttpSession session) throws Exception {
		Retain retain = new Retain();
		retain = (Retain) session.getAttribute("retain");
		PostMessage post = new PostMessage();
		post.setChannel_name(retain.getChannelname());
		post.setChannel_id(retain.getId());

		if (file.isEmpty())
			post.setMessage(message);
		else {
			ServletContext context = session.getServletContext();
			String path = "D:";
			String filename = file.getOriginalFilename();

			System.out.println(path+ filename);

			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			post.setMessage(message);
			post.setUploaded_file(path+"\\"+filename);
		}
		
		post.setUser((User) session.getAttribute("user"));
		notificationService.create(post);
		ModelAndView model = new ModelAndView("posted");
		return model;
	}*/

	@RequestMapping(value = "/pubsub/showlist", method = RequestMethod.POST)
	public List<Channel> getAllChannels(@RequestBody String email) {
        User user=userService.findByEmail(email);
		ModelAndView model = new ModelAndView("channellist");
		List<Channel> list = new ArrayList<Channel>();
		list = channelService.findall(user.getUser_id());
		return list;
	}
	
	@RequestMapping(value = "/pubsub/showAlllist", method = RequestMethod.GET)
	public List<Channel> getChannels(){
		List<Channel> list = new ArrayList<Channel>();
		list=channelService.findallChannels();
		return list;
	}
	
	

}
