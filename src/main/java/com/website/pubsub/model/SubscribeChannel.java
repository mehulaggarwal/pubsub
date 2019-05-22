package com.website.pubsub.model;

public class SubscribeChannel {
	
	private String channel_name;
	
	private int channel_id;
	
	private String user_email;

	/**
	 * @return the channel_name
	 */
	public String getChannel_name() {
		return channel_name;
	}

	/**
	 * @param channel_name the channel_name to set
	 */
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	/**
	 * @return the channel_id
	 */
	public int getChannel_id() {
		return channel_id;
	}

	/**
	 * @param channel_id the channel_id to set
	 */
	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	

}
