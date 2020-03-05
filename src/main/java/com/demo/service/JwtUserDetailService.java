/**
 * 
 */
package com.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dao.MyUserDao;
import com.demo.model.MyUser;

/**
 * @author Mehul
**/

@Service
public class JwtUserDetailService implements UserDetailsService {

	@Autowired
	private MyUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser userModel = userDao.findByUserName(username);
		if(userModel == null) {
			throw new UsernameNotFoundException("user not found with username: "+username);
		}
		if(!userModel.isActive()) {
			System.out.println("user ID is not active!");
		}
		
		return new User(userModel.getUserName(), userModel.getPassword(), new ArrayList<>());
	}
	
}
