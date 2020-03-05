/**
 * 
 */
package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.UserRole;

/**
 * @author Mehul
**/

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {

}
