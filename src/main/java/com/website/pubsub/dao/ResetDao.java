package com.website.pubsub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.pubsub.model.Reset;

@Repository("resetDao")
public interface ResetDao extends CrudRepository<Reset,Integer>{
	
	public Reset findByUrl(String url);

}
