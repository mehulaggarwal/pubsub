package com.website.pubsub.model;

public class MessageResponse {
	
	private String content;

	public MessageResponse(String content) {
		super();
		this.content = content;
	}

	public MessageResponse() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
