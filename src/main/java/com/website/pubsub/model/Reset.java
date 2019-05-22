package com.website.pubsub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reset {

	@Id @GeneratedValue
	private int reset_id;

	private String email;

	@Column(length=100)
	private String url;

	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;

	public int getReset_id() {
		return reset_id;
	}

	public void setReset_id(int reset_id) {
		this.reset_id = reset_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
