package com.revature.repos;

import com.revature.models.USERS;
import com.revature.models.USER_ROLES;

public interface userRolesDAO {
 
	USER_ROLES getRole(USERS user);
}
