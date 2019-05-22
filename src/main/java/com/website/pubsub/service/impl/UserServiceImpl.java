/**
 * 
 */
/**
 * @author Mehul
 *
 */
package com.website.pubsub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.pubsub.dao.UserDao;
import com.website.pubsub.model.User;
import com.website.pubsub.service.UserService;

@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public void create(User user) {
		userDao.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public void updatePassword(String password, String email) {
		userDao.updatePassword(password, email);
		
	}

}
