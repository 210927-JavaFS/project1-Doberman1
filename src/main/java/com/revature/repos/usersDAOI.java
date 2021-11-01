package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.models.USERS;
import com.revature.utils.HibernateUtil;

public class usersDAOI implements usersDAO{

	@Override
	public boolean createUser(USERS user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx  = session.beginTransaction();
			session.save(user);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
				
			}
	}

	@Override
	public boolean updateUser(USERS user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx  = session.beginTransaction();
			session.merge(user);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
				
			}
	}

	@Override
	public USERS getUser(String username) {
		
		List<USERS> allUsers = findAllUsers();
		int ID = 0;
		
		for(USERS user : allUsers) {
			if(user.getUsername().equals(username)) {
				 ID = user.getUsersID();
				
			}
		}
		
		Session session = HibernateUtil.getSession();
		return session.get(USERS.class, ID);
	}

	public List<USERS> findAllUsers(){
		
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM USERS").list();
	}
}
