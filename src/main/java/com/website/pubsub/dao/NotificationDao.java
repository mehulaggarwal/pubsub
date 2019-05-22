package com.website.pubsub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.pubsub.model.PostMessage;

@Repository("notificationDao")
public interface NotificationDao extends CrudRepository<PostMessage, Integer> {

	@Query(value = "select * from post_message where notification_id IN  (select notification_id from post_message left join delete_messages using(Notification_id) where delete_messages.notification_id is NULL ) and channel_id=?1 order by notification_id desc",nativeQuery=true)
	public List<PostMessage> findbyId(int id);

}
