package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.driver.Log4j;
import com.model.LikeType;
import com.util.HibernateUtil;

public class LikeTypeDao implements DaoContract<LikeType> {

	@Override
	public List<LikeType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LikeType findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LikeType update(LikeType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LikeType insert(LikeType t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		Log4j.log.info("New like type has been created.");
		return t;
	}

	@Override
	public LikeType delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LikeType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
