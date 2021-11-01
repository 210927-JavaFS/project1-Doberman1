package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class REIMBURSEMENT_STATUS {

	@Id
	private int reimbStatusID;
	private String reimbStatus;
	
	
	public REIMBURSEMENT_STATUS(int reimbStatusID, String reimbStatus) {
		super();
		this.reimbStatusID = reimbStatusID;
		this.reimbStatus = reimbStatus;
	}


	public REIMBURSEMENT_STATUS(String reimbStatus) {
		super();
		this.reimbStatus = reimbStatus;
	}


	public REIMBURSEMENT_STATUS() {
		super();
	}


	public int getReimbStatusID() {
		return reimbStatusID;
	}


	public String getReimbStatus() {
		return reimbStatus;
	}


	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + reimbStatusID;
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
		REIMBURSEMENT_STATUS other = (REIMBURSEMENT_STATUS) obj;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbStatusID != other.reimbStatusID)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT_STATUS [reimbStatusID=" + reimbStatusID + ", reimbStatus=" + reimbStatus + "]";
	}
	
	
	
}
