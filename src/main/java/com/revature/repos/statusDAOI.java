package com.revature.repos;

import org.hibernate.Session;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.REIMBURSEMENT_STATUS;
import com.revature.utils.HibernateUtil;

public class statusDAOI implements statusDAO{

	@Override
	public REIMBURSEMENT_STATUS getStatus(REIMBURSEMENT reimb) {
		Session session = HibernateUtil.getSession();
		int statusID = reimb.getStatus().getReimbStatusID();
		return session.get(REIMBURSEMENT_STATUS.class, statusID);
	}

}
