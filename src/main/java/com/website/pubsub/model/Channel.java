/**
 * 
 */
/**
 * @author Mehul
 *
 */

package com.website.pubsub.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;



@Entity
@Table(name="Create_Channel")
public class Channel {
	

	@Id @GeneratedValue
	private int channel_id;
	
	private String channel_name;
	
	private String channel_info;
   
	private String admin_name;
	
	/**
	 * @return the admin_name
	 */
	public String getAdmin_name() {
		return admin_name;
	}

	/**
	 * @param admin_name the admin_name to set
	 */
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getChannel_info() {
		return channel_info;
	}

	public void setChannel_info(String channel_info) {
		this.channel_info = channel_info;
	}

	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public synchronized int getChannel_id() {
		return channel_id;
	}

	public synchronized void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public synchronized User getUser() {
		return user;
	}

	public synchronized void setUser(User user) {
		this.user = user;
	}


}
