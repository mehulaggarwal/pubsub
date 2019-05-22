package com.website.pubsub.model;

public class Message {
	
	private String name;
	
	private int unique_id;

	public Message() {
	}

	public Message(String name, int unique_id) {
		super();
		this.name = name;
		this.unique_id = unique_id;
	}

	public String getName() {
		return name;
	}

	public int getUnique_id() {
		return unique_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}

	

}
