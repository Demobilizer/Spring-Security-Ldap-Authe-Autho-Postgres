/**
 * 
 */
package com.demo.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.MyUserDao;
import com.demo.dao.PrivilegesDao;
import com.demo.dao.RoleDao;
import com.demo.dao.RolePrivilegesDao;
import com.demo.dao.UserRoleDao;
import com.demo.model.MyUser;
import com.demo.model.Privileges;
import com.demo.model.Role;
import com.demo.model.RolePrivileges;
import com.demo.model.UserRole;

/**
 * @author Mehul
**/

@RestController
public class CrudController {

	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PrivilegesDao privilegesDao;
	
	@Autowired
	RolePrivilegesDao rolePrivilegesDao;
	
	@Autowired
	MyUserDao myUserDao;
	
	@Autowired
	UserRole userRole;
	
	@Autowired
	UserRoleDao userRoleDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// take a JsonString in @RequestBody, from FRONT with privileges & convert into 2 diff objects
	
	@PostMapping("/addRole")
	public String addRole(@RequestBody String roleJsonStr) throws ParseException {
		
		JSONObject roleJson = new JSONObject();
		JSONParser jsonParser = new JSONParser();
		System.out.println("string is-------------------"+roleJsonStr);
		roleJson = (JSONObject) jsonParser.parse(roleJsonStr);
		
		String roleName = roleJson.get("roleName").toString();
		
		Role role = new Role();
		role.setRoleName(roleName);
		
		Role roleAdded = roleDao.save(role);
		System.out.println("role saved successfully");
		
		JSONArray privilegeArr = (JSONArray) roleJson.get("privileges");
		
		for (Object privilege : privilegeArr) {
			
			Privileges privilegeObj = privilegesDao.findByPrivilegeName(privilege.toString());
			
			RolePrivileges rolePrivilege = new RolePrivileges();
			rolePrivilege.setRoleId(roleAdded);
			rolePrivilege.setPrivilegeId(privilegeObj);
			
			rolePrivilegesDao.save(rolePrivilege);
		}
		
		return "role with privil saved successfully";
	}
	
	@GetMapping("/viewRoles")
	public List<Role> viewRoles() {
		return roleDao.findAll();
	}
	
	@DeleteMapping("/deleteRole/{roleId}")
	public String deleteRole(@PathVariable int roleId) {
		roleDao.deleteById(roleId);
		return "delete success";
	}
	
	@PutMapping("/updateRole")
	public String updateRole(@RequestBody Role role) {
		System.out.println("role details---"+role.toString());
		roleDao.save(role);
		return "updated..";
	}
	
	@PostMapping("/addPrivilege")
	public String addPrivileges(@RequestBody Privileges privileges) {
		privilegesDao.save(privileges);
		return "privileges saved successfully";
	}
	
	@GetMapping("/viewPrivileges")
	public List<Privileges> viewPrivileges() {
		return privilegesDao.findAll();
	}
	
	@DeleteMapping("/deletePrivilege/{PrivilegeId}")
	public String deletePrivilege(@PathVariable int PrivilegeId) {
		privilegesDao.deleteById(PrivilegeId);
		return "delete success";
	}
	
	@PutMapping("/updatePrivilege")
	public String updatePrivilege(@RequestBody Privileges privileges) {
		System.out.println("pri details---"+privileges.toString());
		privilegesDao.save(privileges);
		return "updated..";
	}
	
	@PostMapping("/addUser")
	public String addMyUser(@RequestBody String userJsonStr) throws ParseException {
		
		JSONObject userJson = new JSONObject();
		JSONParser jsonParser = new JSONParser();
		System.out.println("string is-------------------"+userJsonStr);
		
		userJson = (JSONObject) jsonParser.parse(userJsonStr);
		String userName = userJson.get("userName").toString();
		String emailId = userJson.get("emailId").toString();
		String encodedPwd = passwordEncoder.encode(userJson.get("password").toString());
		//String password = userJson.get("password").toString();
		
		MyUser user = new MyUser();
		user.setUserName(userName);
		user.setEmailId(emailId);
		user.setPassword(encodedPwd);
		user.setActive(true);
		
		MyUser userAdded = myUserDao.save(user);
		System.out.println("user saved successfully");
		
		JSONArray roleArr = (JSONArray) userJson.get("roles");
		
		for (Object role : roleArr) {
			
			Role roleObj = roleDao.findByRoleName(role.toString());
			
			UserRole userRole = new UserRole();
			userRole.setUserId(userAdded);
			userRole.setRoleId(roleObj);
			
			userRoleDao.save(userRole);
		}
		
		return "user and userRole saved successfully!";
	}
	
	@GetMapping("/viewUsers")
	public List<MyUser> viewUsers() {
		return myUserDao.findAll();
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable int userId) {
		myUserDao.deleteById(userId);
		return "delete user success";
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody MyUser user) {
		System.out.println("user details---"+user.toString());
		myUserDao.save(user);
		return "updated..";
	}
	
}
