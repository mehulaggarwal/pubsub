package com.website.pubsub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Post_Message")
public class PostMessage {

	@Column(length =8000)
	private String message;

	@Id
	@GeneratedValue
	private int Notification_id;

	private int channel_id;

	private String Uploaded_file;

	private String channel_name;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNotification_id() {
		return Notification_id;
	}

	public void setNotification_id(int notification_id) {
		Notification_id = notification_id;
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public String getUploaded_file() {
		return Uploaded_file;
	}

	public void setUploaded_file(String uploaded_file) {
		Uploaded_file = uploaded_file;
	}

}
