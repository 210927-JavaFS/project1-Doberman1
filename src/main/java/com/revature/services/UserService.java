package com.revature.services;

import com.revature.models.USERS;
import com.revature.repos.usersDAO;
import com.revature.repos.usersDAOI;

public class UserService {
	
	private static usersDAO userDao = new usersDAOI();
	
	//boolean createUser(USERS user) {
		
	//	return userDao.createUser(user);
	//}
	//boolean updateUser(USERS user) {
		
	//	return userDao.updateUser(user);
	//}
	public static USERS getUser(String username) {
		USERS user = userDao.getUser(username);
		if(user != null) {
			
			return user;
		}else {
			return new USERS();
			
		}
		
	}
}
