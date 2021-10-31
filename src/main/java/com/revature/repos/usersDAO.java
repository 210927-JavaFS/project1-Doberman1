package com.revature.repos;


import com.revature.models.USERS;

public interface usersDAO {

	boolean createUser(USERS user);
	boolean updateUser(USERS user);
	USERS getUser(String username);

	
}
