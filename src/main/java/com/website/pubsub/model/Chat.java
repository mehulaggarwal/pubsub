package com.website.pubsub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Chat_information")
public class Chat {
	
	private int admin_id;

	@Id @GeneratedValue
	private int chat_id;

	private String messages;


	private String sender_name;

	private int subscriber_id;

	private int unique_id;
	
	public int getAdmin_id() {
		return admin_id;
	}
	
	public int getChat_id() {
		return chat_id;
	}

	public String getMessages() {
		return messages;
	}

	

	/**
	 * @return the sender_name
	 */
	public String getSender_name() {
		return sender_name;
	}

	public int getSubscriber_id() {
		return subscriber_id;
	}

	public int getUnique_id() {
		return unique_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	
	/**
	 * @param sender_name the sender_name to set
	 */
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	
	public void setSubscriber_id(int subscriber_id) {
		this.subscriber_id = subscriber_id;
	}
	
	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}

}
