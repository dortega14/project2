package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.driver.Log4j;
import com.model.User;
import com.util.HibernateUtil;

@Repository
public class UserDao implements DaoContract<User> {
	
	public UserDao() {
		HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<User> findAll() {
		List<User> list = HibernateUtil.getSessionFactory().openSession().
				createNativeQuery("select * from rockstar", User.class).list();
		Log4j.log.info("The list of user has been read.");
		return list;
	}

	@Override
	public User findById(int id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sess.beginTransaction();
		User user = sess.get(User.class, id);
		tx.commit();
		Log4j.log.info("User found with ID number.");
		return user;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		Log4j.log.info("User information updated.");
		return null;
	}

	@Override
	public User insert(User t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		Log4j.log.info("New user has been created.");
		return t;
	}

	@Override
	public User delete(int id) {
		// TODO Auto-generated method stub
		Log4j.log.info("User has been deleted.");
		return null;
	}

	@Override
	public User findByName(String name) {
		Session ses = HibernateUtil.getSessionFactory().openSession();
		Log4j.log.info("User information pulled up through username.");
		return ses.createQuery("from rockstar where name = '" + name + "'", User.class).list().get(0);
	}

	

}
