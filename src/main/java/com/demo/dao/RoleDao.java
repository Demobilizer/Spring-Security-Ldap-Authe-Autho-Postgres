/**
 * 
 */
package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Role;

/**
 * @author Mehul
**/

public interface RoleDao extends JpaRepository<Role, Integer> {

	/**
	 * @param string
	 * @return
	 */
	Role findByRoleName(String string);

}
