/**
 * 
 */
package com.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Mehul
**/

@Entity
@Table(name = "user_master")
@Data
public class MyUser {

	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String emailId;
	private String password;
	private boolean isActive;
	
	@Column
	private Date created;
	
	@Column
	private Date updated;
	
	@PrePersist
	  protected void onCreate() {
	    created = new Date();
	  }
	
	@PreUpdate
	  protected void onUpdate() {
	    updated = new Date();
	  }
}
