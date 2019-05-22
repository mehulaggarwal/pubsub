package com.website.pubsub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.pubsub.model.Subscriber;

@Repository("subscriberDao")
public interface SubscriberDao extends CrudRepository<Subscriber, Integer>{

	@Query(value="Select * from Subscriber_info where user_id=?1",nativeQuery=true)
	public List<Subscriber> findbyUserid(int user_id);
	
	@Query(value="Select user_id from Subscriber_info where channel_id=?1",nativeQuery=true)
	public List<Integer> getUserid(int channel_id);
	
	@Modifying
	@Query(value="delete from subscriber_info where channel_id=?1 and user_id=?2",nativeQuery=true)
	public void Unsusbcribe(int channel_id,int user_id);
}
