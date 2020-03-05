/**
 * 
 */
package com.demo.model;

import java.io.Serializable;

/**
 * @author Mehul
**/

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 798675558622681694L;

	private final String jwtToken;

	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
}
