/**
 * 
 */
package com.demo.model;

import java.io.Serializable;

/**
 * @author Mehul
**/

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -6287127665961395347L;

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JwtRequest() {
		
	}
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
