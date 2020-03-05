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

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Mehul
**/

@Component
@Entity
@Table(name = "user_role")
@Data
public class UserRole {

	@Id
	@GeneratedValue
	private int userRoleId;
	
	@ManyToOne(targetEntity = MyUser.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
	private MyUser userId;
	
	@ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "role_id")
	private Role roleId;
	
}
