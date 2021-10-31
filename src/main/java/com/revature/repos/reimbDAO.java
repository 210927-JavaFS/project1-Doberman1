package com.revature.repos;

import java.util.List;

import com.revature.models.REIMBURSEMENT;

public interface reimbDAO {

	List<REIMBURSEMENT> findAllReimb();
	List<REIMBURSEMENT> findReimbByUserID(int userID);
	REIMBURSEMENT findByID(int ID);
	boolean createReimb(REIMBURSEMENT reimb);
	boolean updateReimb(REIMBURSEMENT reimb);
	
	
}
