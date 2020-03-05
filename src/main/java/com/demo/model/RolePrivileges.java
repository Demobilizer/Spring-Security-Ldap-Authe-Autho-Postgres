/**
 * 
 */
package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Mehul
**/

@Entity
@Table(name = "role_privileges")
@Data
public class RolePrivileges {

	@Id
	@GeneratedValue
	private int rolePrivilegeId;
	
	@ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "role_id")
	private Role roleId;
	
	@ManyToOne(targetEntity = Privileges.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "privilege_id")
	private Privileges privilegeId;
	
}
