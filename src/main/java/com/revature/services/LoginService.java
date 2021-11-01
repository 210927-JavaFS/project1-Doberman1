package com.revature.services;

import com.revature.models.USERS;
import com.revature.models.UserDTO;
import com.revature.repos.usersDAO;
import com.revature.repos.usersDAOI;

public class LoginService {

	public static USERS user = new USERS();
	private usersDAO userDao = new usersDAOI();
	
	public boolean login(UserDTO userDto) {
		
		
		USERS user = userDao.getUser(userDto.username);
		
		if(user!=null && (userDto.password.hashCode()==user.getPassword())) {
			this.user=user;
			return true;
			
		}
		
		return false;
	}
}
