package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class USER_ROLES {

	@Id
	private int userRoleID;
	private String userRole;
	
	public USER_ROLES(int userRoleID, String userRole) {
		super();
		this.userRoleID = userRoleID;
		this.userRole = userRole;
	}

	public USER_ROLES(String userRole) {
		super();
		this.userRole = userRole;
	}

	public USER_ROLES() {
		super();
	}

	public int getUserRoleID() {
		return userRoleID;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + userRoleID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		USER_ROLES other = (USER_ROLES) obj;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userRoleID != other.userRoleID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ERS_USER_ROLES [userRoleID=" + userRoleID + ", userRole=" + userRole + "]";
	}
	
}
