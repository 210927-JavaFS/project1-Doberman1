package com.revature.services;

import com.revature.models.USERS;
import com.revature.repos.usersDAO;
import com.revature.repos.usersDAOI;

public class UserService {
	
	private usersDAO userDAO = new usersDAOI();
	
	boolean createUser(USERS user) {
		
		return userDAO.createUser(user);
	}
	boolean updateUser(USERS user) {
		
		return userDAO.updateUser(user);
	}
	USERS getUser(String username) {
		USERS user = userDAO.getUser(username);
		if(user != null) {
			
			return user;
		}else {
			return new USERS();
			
		}
		
	}
}
