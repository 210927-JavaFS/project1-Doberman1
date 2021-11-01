package com.revature.services;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.REIMBURSEMENT_STATUS;
import com.revature.repos.statusDAO;
import com.revature.repos.statusDAOI;

public class StatusService {

	private statusDAO statusDAO = new statusDAOI();
	
	REIMBURSEMENT_STATUS getStatus(REIMBURSEMENT reimb){
		
		REIMBURSEMENT_STATUS status = statusDAO.getStatus(reimb);
		if(status != null) {
			
			return status;
		}else {
			return new REIMBURSEMENT_STATUS();
			
		}
	}
	
}
