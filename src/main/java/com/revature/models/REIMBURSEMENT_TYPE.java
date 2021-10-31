package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class REIMBURSEMENT_TYPE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reimbTypeID;
	private String reimbType;
	
	
	
	
	public REIMBURSEMENT_TYPE() {
		super();
	}
	public REIMBURSEMENT_TYPE(String reimbType) {
		super();
		this.reimbType = reimbType;
	}
	public REIMBURSEMENT_TYPE(int reimbTypeID, String reimbType) {
		super();
		this.reimbTypeID = reimbTypeID;
		this.reimbType = reimbType;
	}
	public int getReimbTypeID() {
		return reimbTypeID;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + reimbTypeID;
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
		REIMBURSEMENT_TYPE other = (REIMBURSEMENT_TYPE) obj;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (reimbTypeID != other.reimbTypeID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT_TYPE [reimbTypeID=" + reimbTypeID + ", reimbType=" + reimbType + "]";
	}
	
	
	
	
}
