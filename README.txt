Spring-Security-Ldap-Authe-Autho-Postgres:

to develope views:

CRUD: (note: for every CRUD, send id while sending UPDATE Request)

1) make a view for privileges CRUD 
2) make a view for roles (have to give privils while adding roles) CRUD
	
		demo JSON for request to add ROLE:
			{
				"roleName":"test",
				"privileges":["READ","CREATE","UPDATE","DELETE"]
			}

3) make a view for users (have to gvie role(s) while adding users) CRUD

		demo JSON for request to add user:
			{
				"userName":"test",
				"emailId":"x@y.z",
				"password":"abc",
				"roles":["ROLE_ADMIN","ROLE_USER"]
			}


4) 

-------------------------------------------------------------------------------------------------------------

step 1:
		login using following POST request:

		http://localhost:8080/authenticate

		{
			"username":"admin",
			"password":"admin"
		}

		it'll return JWT token!!!!!

step 2:
		append that JWT Token in header with all the following requests: