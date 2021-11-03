package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.REIMBURSEMENT;
import com.revature.utils.HibernateUtil;

public class reimbDAOI implements reimbDAO{

	
	public List<REIMBURSEMENT> findAllReimb() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM REIMBURSEMENT").list();
		//return null;
	}

	
	public List<REIMBURSEMENT> findReimbByUserID(int userID) {
		
		List<REIMBURSEMENT> list = findAllReimb();
		List<REIMBURSEMENT> newlist = findAllReimb();
		//System.out.print(list);
		
		
		for(REIMBURSEMENT r : list) {
			if(userID != r.getAuthor().getUsersID()) {
				newlist.remove(r);
			}
			
		}
		
		System.out.print(newlist);
		return newlist;
		//Session session = HibernateUtil.getSession();
		//return session.createQuery("FROM REIMBURSEMENT").list();
		
		//return null;
	}

	
	public REIMBURSEMENT findByID(int ID) {
		Session session = HibernateUtil.getSession();
		
		return session.get(REIMBURSEMENT.class, ID);
		
	}

	
	public boolean createReimb(REIMBURSEMENT reimb) {
		try {
		reimb.setResolved(null);
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
