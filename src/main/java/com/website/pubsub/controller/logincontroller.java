/**
 * 
 */
/**
 * @author Mehul
 *
 */

package com.website.pubsub.controller;

import com.website.pubsub.model.Channel;
import com.website.pubsub.model.HomePage;
import com.website.pubsub.model.Subscriber;
import com.website.pubsub.model.User;
import com.website.pubsub.service.ChannelService;
import com.website.pubsub.service.SubscriberService;
import com.website.pubsub.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class logincontroller {

	@Autowired
	UserService userService;
	
	@Autowired
	ChannelService channelService;
	
     @Autowired
     SubscriberService subscriberService;

	@RequestMapping("/pubsub/register")
	public ModelAndView register() {
		ModelAndView model = new ModelAndView("register");
		return model;
	}

	@RequestMapping(value = "/pubsub/home", method = RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute("User1") User User1, HttpSession session) {

		
		/*//Use your email and password here
		final String username = "mehulaggarwal29@gmail.com";
		final String password = "199agmehul";

		// to send email whille registering
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress("mehulaggarwal29@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(User1.getEmail()));
			message.setSubject("Registered");
			message.setText("Dear " + User1.getUserName() + ","
					+ "\n\nYou have registerd to our website.You can now use our services free of cost" + "\n\nRegards"
					+ "\nPubsub team");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
*/
		userService.create(User1);
		ModelAndView model = new ModelAndView("LoginSuccess");
		return model;
	}
	
	@RequestMapping(value="/pubsub/signUp",method = RequestMethod.POST)
	public User signUp(@RequestBody User user) {
		userService.create(user);
		return user;
	}
	
	@RequestMapping(value = "/pubsub/homePage/{userId}", method = RequestMethod.GET)
	public HomePage homePage(@PathVariable("userId") int userId) {
		HomePage homePage = new HomePage();
		homePage.setChannelsCreated(channelService.findbyUser_id(userId));
		homePage.setSubscribedChannels(subscriberService.findbyUserid(userId));
		return homePage;
	}
	
	@RequestMapping(value = "/pubsub/login", method = RequestMethod.POST)
	public User login(@RequestBody User loginUser) {
		User user2 = userService.findByEmail(loginUser.getEmail());
		if (user2 == null) {
			return null; 
		}
	
		String s1 = user2.getPassword();
		String s2 = loginUser.getPassword();
		if (!s1.equals(s2)) {
			return null;
		}
		return user2;
	}

	@RequestMapping(value = "/pubsub/home1", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("User1") User LoginUser, HttpSession session,
			HttpServletRequest request) {
		User user2 = new User();
		user2 = userService.findByEmail(LoginUser.getEmail());
		if (user2 == null) {
			return new ModelAndView("LoginUnsuccess");
		}
		session.setAttribute("user", user2);
		String s1 = user2.getPassword();
		String s2 = LoginUser.getPassword();
		if (!s1.equals(s2)) {
			return new ModelAndView("LoginUnsuccess");
		}
		 List<Channel> list = new ArrayList<Channel>();
		ModelAndView model = new ModelAndView("LoginSuccess");
		session.setAttribute("subscriber_user_id",user2.getUser_id());
		list = channelService.findbyUser_id(user2.getUser_id());
		model.addObject("lists", list);

		List<Subscriber> list1=new ArrayList<Subscriber>();
		list1=subscriberService.findbyUserid(user2.getUser_id());
		model.addObject("lists1",list1);
		return model;

	}

	@RequestMapping(value = "/pubsub/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/pubsub");
	}

	@RequestMapping(value="/pubsub/getUserName",method=RequestMethod.POST)
	public User getUserName(@RequestBody String user_email) {
		User user=userService.findByEmail(user_email);
		return user;
	}
}
