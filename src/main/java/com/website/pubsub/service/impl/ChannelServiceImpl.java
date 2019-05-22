/**
 * 
 */
/**
 * @author Mehul
 *
 */
package com.website.pubsub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.pubsub.dao.ChannelDao;
import com.website.pubsub.model.Channel;
import com.website.pubsub.service.ChannelService;

@Service("channelService")
@Transactional(rollbackFor=Exception.class)
public class ChannelServiceImpl implements ChannelService{

	@Autowired
	ChannelDao channelDao;
	
	@Override
	public void create(Channel channel) {
		channelDao.save(channel);
		
	}

	@Override
	public List<Channel> findbyUser_id(int user_id) {
		return channelDao.findbyUser_id(user_id);
	}

	@Override
	public List<Channel> findall(int user_id) {
		return channelDao.findall(user_id);
	}

	@Override
	public Channel findbychannel_id(int channel_id) {
	   return channelDao.findbychannel_id(channel_id);
	}

	@Override
	public int getChannelid(int user_id) {
		return channelDao.getChannelid(user_id);
	}

	@Override
	public List<Channel> findallChannels() {
		return channelDao.findallChannels();
	}


}
