package com.website.pubsub.model;


import org.springframework.web.multipart.MultipartFile;

public class MessageUser {
	
	private MultipartFile file;
	
	private String message;

	private String user_email;


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}

	public MessageUser() {
		super();
	}


	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	
	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	

}
