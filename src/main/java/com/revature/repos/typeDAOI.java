package com.revature.repos;

import org.hibernate.Session;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.REIMBURSEMENT_TYPE;
import com.revature.utils.HibernateUtil;

public class typeDAOI implements typeDAO{

	@Override
	public REIMBURSEMENT_TYPE getType(REIMBURSEMENT reimb) {
		Session session = HibernateUtil.getSession();
		int typeID = reimb.getType().getReimbTypeID();
		return session.get(REIMBURSEMENT_TYPE.class, typeID);
	}

}
