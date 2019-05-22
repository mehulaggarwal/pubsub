/**
 * 
 */
/**
 * @author Mehul
 *
 */

package com.website.pubsub.service;

import java.util.List;

import com.website.pubsub.model.Channel;

public interface ChannelService {
	
	public void create(Channel channel);
	
	public List<Channel> findbyUser_id(int user_id);
	
	public List<Channel> findall(int user_id);
	
	public Channel findbychannel_id(int channel_id);
	
	public int getChannelid(int user_id);
	
	public List<Channel> findallChannels();

}
