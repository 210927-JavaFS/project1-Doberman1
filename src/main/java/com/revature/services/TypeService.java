package com.revature.services;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.REIMBURSEMENT_TYPE;
import com.revature.repos.typeDAO;
import com.revature.repos.typeDAOI;

public class TypeService {
	
	private typeDAO typeDAO = new typeDAOI();

	REIMBURSEMENT_TYPE getType(REIMBURSEMENT reimb) {
		
		REIMBURSEMENT_TYPE type = typeDAO.getType(reimb);
		if(type != null) {
			
			return type;
		}else {
			return new REIMBURSEMENT_TYPE();
			
		}
	}
	
}
