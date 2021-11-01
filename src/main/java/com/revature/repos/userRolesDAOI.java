package com.revature.repos;

import org.hibernate.Session;

import com.revature.models.USERS;
import com.revature.models.USER_ROLES;
import com.revature.utils.HibernateUtil;

public class userRolesDAOI implements userRolesDAO{

	@Override
	public USER_ROLES getRole(USERS user) {
		Session session = HibernateUtil.getSession();
		int roleID = user.getUserRole().getUserRoleID();
		return session.get(USER_ROLES.class, roleID);
	}

}
