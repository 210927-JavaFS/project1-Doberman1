package com.revature.repos;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.REIMBURSEMENT_STATUS;

public interface statusDAO {

	REIMBURSEMENT_STATUS getStatus(REIMBURSEMENT reimb);
}
