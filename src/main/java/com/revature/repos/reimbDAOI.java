package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.REIMBURSEMENT;
import com.revature.utils.HibernateUtil;

public class reimbDAOI implements reimbDAO{

	@Override
	public List<REIMBURSEMENT> findAllReimb() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM REIMBURSEMENT").list();
		//return null;
	}

	@Override
	public List<REIMBURSEMENT> findReimbByUserID(int userID) {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM REIMBURSEMENT AS R WHERE R.author = "+Integer.toString(userID)).list();
		//return null;
	}

	@Override
	public REIMBURSEMENT findByID(int ID) {
		Session session = HibernateUtil.getSession();
		return session.get(REIMBURSEMENT.class, ID);
	}

	@Override
	public boolean createReimb(REIMBURSEMENT reimb) {
		try {
		Session session = HibernateUtil.getSession();
		Transaction tx  = session.beginTransaction();
		session.save(reimb);
		tx.commit();
		HibernateUtil.closeSession();
		return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean updateReimb(REIMBURSEMENT reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx  = session.beginTransaction();
			session.merge(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
				
			}
	}

}
