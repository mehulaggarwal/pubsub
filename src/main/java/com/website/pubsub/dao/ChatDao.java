package com.website.pubsub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.pubsub.model.Chat;

@Repository("chatDao")
public interface ChatDao extends CrudRepository<Chat, Integer>{

	@Query(value="select * from Chat_information where unique_id=?1",nativeQuery=true)
	public List<Chat> findbyUnique_id(int id);
	
}
  