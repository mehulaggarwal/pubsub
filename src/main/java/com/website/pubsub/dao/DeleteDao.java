package com.website.pubsub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.pubsub.model.Delete;

@Repository("deleteDao    ")
public interface DeleteDao extends CrudRepository<Delete, Integer>{

}
