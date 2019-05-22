package com.website.pubsub.service;

import com.website.pubsub.model.Reset;

public interface ResetService {
	
	public void create(Reset reset);
	
	public Reset findByUrl(String url);

}
