/**
 * 
 */
package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.MyUser;

/**
 * @author Mehul
**/

public interface MyUserDao extends JpaRepository<MyUser, Integer> {

	/**
	 * @param username
	 * @return
	 */
	MyUser findByUserName(String username);

}
