package com.website.pubsub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.website.pubsub.model.Channel;

@Repository("channelDao")
public interface ChannelDao extends CrudRepository<Channel, Integer>{
	
	@Query(value="Select * from Create_Channel where user_id=?1",nativeQuery=true)
	public List<Channel> findbyUser_id(int user_id);
	
	@Query(value="Select * from Create_Channel where user_id!=?1",nativeQuery=true)
	public List<Channel> findall(int user_id);
    
	@Query(value="select * from create_channel where channel_id=?1",nativeQuery=true)
	public Channel findbychannel_id(int channel_id);

	@Query(value="select channel_id from create_channel where user_id=?1",nativeQuery=true)
	public int getChannelid(int user_id);
	
	@Query(value="Select * from Create_Channel",nativeQuery=true)
	public List<Channel> findallChannels();
	
}
