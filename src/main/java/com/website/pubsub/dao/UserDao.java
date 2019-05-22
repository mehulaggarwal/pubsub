/**
 * 
 */
/**
 * @author Mehul
 *
 */

package com.website.pubsub.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.pubsub.model.User;

@Repository("userDao")
public interface UserDao extends CrudRepository<User,Integer>{
	
	public User findByEmail(String email);
	
	@Modifying
	@Query(value="UPDATE user_information SET password=?1 where email=?2",nativeQuery=true)
	public void updatePassword(String password,String email);

}
