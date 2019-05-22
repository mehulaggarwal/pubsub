package com.website.pubsub.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.pubsub.model.Password;
import com.website.pubsub.model.Reset;
import com.website.pubsub.service.ResetService;
import com.website.pubsub.service.UserService;


@Controller
public class ResetController {
	
	@Autowired
	ResetService resetService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/pubsub/forget_password", method = RequestMethod.POST)
	public ModelAndView reset_password(@ModelAttribute("reset") Reset reset) {
		int length = 70;
		boolean useLetters = true;
		boolean useNumbers = true;
		String url = RandomStringUtils.random(length, useLetters, useNumbers);
		reset.setUrl(url);
		resetService.create(reset);
		System.out.println(url);
		
		//Use your email and password
		final String username = "mehulaggarwal29@gmail.com";
		final String password = "199agmehul";

		// to send email whille changing the password
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session1 = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress("mehulaggarwal29@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(reset.getEmail()));
			message.setSubject("Registered");
			message.setText("We heard that you lost your password. Sorry about that!"
					+"\n\nBut don’t worry! You can use the following link to reset your password:"
					+"\n\nhttp://localhost:8080/pubsub/reset_password/"+url
					+"\n\nThanks,"+"\nPubsub Team");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		ModelAndView model = new ModelAndView("BackToLogin");
		return model;
		
	}
	
	@RequestMapping(value="/pubsub/reset_password/{url}")
	public ModelAndView change_password(@PathVariable("url")String url,HttpSession session)
	{
		session.setAttribute("url",url);
		ModelAndView model=new ModelAndView("Change_Password");
		return model;
	}
	
	@RequestMapping(value="/pubsub/reset_password")
	public ModelAndView resetPassword()
	{
		ModelAndView model=new ModelAndView("Forget_Password");
		return model;
	}
	
	@RequestMapping(value="/pubsub/change_password",method=RequestMethod.POST)
	public ModelAndView changePassword(@ModelAttribute("password1") Password password1,HttpSession session) {
		
		String s1=password1.getPassword();
		String s2=password1.getPassword_again();
		if(!s1.equals(s2))
		{
			
			ModelAndView model=new ModelAndView("unmatched");
			return model;
		}
		String url=(String)session.getAttribute("url");
		Reset reset=new Reset();
		reset=resetService.findByUrl(url);
		String email=reset.getEmail();
		System.out.println(email);
		userService.updatePassword(password1.getPassword(), email);
		ModelAndView model=new ModelAndView("BackToLogin");
		return model;
				
	}

}
