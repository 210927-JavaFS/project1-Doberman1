package com.revature.services;

import com.revature.models.USERS;
import com.revature.models.USER_ROLES;
import com.revature.repos.userRolesDAO;
import com.revature.repos.userRolesDAOI;

public class RoleService {

private userRolesDAO rolesDAO = new userRolesDAOI();
	
	public USER_ROLES getRole(USERS user){
		
		USER_ROLES role = rolesDAO.getRole(user);
		if(role != null) {
			
			return role;
		}else {
			return new USER_ROLES();
			
		}
	}
	
}
