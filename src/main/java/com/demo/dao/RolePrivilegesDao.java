/**
 * 
 */
package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.RolePrivileges;

/**
 * @author Mehul
**/

public interface RolePrivilegesDao extends JpaRepository<RolePrivileges, Integer> {

}
