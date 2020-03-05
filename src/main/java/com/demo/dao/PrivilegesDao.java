/**
 * 
 */
package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Privileges;

/**
 * @author Mehul
**/

public interface PrivilegesDao extends JpaRepository<Privileges, Integer> {

	/**
	 * @param privilegeName
	 * @return
	 */
	Privileges findByPrivilegeName(String privilegeName);
	
}
