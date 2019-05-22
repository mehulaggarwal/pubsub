/**
 * 
 */
/**
 * @author Mehul
 *
 */

package com.website.pubsub.service;

import com.website.pubsub.model.User;

public interface UserService {
	
	public void create(User user);
	
	public User findByEmail(String email);
	
	public void updatePassword(String password,String email);

}
