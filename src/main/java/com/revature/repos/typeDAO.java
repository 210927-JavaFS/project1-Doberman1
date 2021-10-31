package com.revature.repos;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.REIMBURSEMENT_TYPE;

public interface typeDAO {

	REIMBURSEMENT_TYPE getType(REIMBURSEMENT reimb);
}
