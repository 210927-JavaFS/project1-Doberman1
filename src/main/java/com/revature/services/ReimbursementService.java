package com.revature.services;

import java.util.List;

import com.revature.models.REIMBURSEMENT;
import com.revature.repos.reimbDAO;
import com.revature.repos.reimbDAOI;

public class ReimbursementService {

	private reimbDAO reimbDAO = new reimbDAOI();
	
	public List<REIMBURSEMENT> findAllReimb(){
		return reimbDAO.findAllReimb();
		
	}
	public List<REIMBURSEMENT> findReimbByUserID(int userID){
		
		return reimbDAO.findReimbByUserID(userID);
		
	}
	public REIMBURSEMENT findByID(int ID) {
		
		REIMBURSEMENT reimb = reimbDAO.findByID(ID);
		if(reimb != null) {
			
			return reimb;
		}else {
			return null;
			
		}
	}
	public boolean createReimb(REIMBURSEMENT reimb) {
		return reimbDAO.createReimb(reimb);
		
	}
	public boolean updateReimb(REIMBURSEMENT reimb) {
		System.out.println("in the service");
		return reimbDAO.updateReimb(reimb);
		
		
	}
}
