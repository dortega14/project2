package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Comment;

/**
 * @author TeamLeo
 * Contains the CRUD methods for the Comment Model.
 */
@Repository
@Transactional
public class CommentDao {

	private SessionFactory sesfact;
	
	@Autowired
	public CommentDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	public List<Comment> findAll() {
		return sesfact.getCurrentSession().createQuery("from Comment", Comment.class).list();
	}

	public Comment findById(int id) {
		return sesfact.getCurrentSession().get(Comment.class, id);
	}

	public Comment update(Comment t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public Comment insert(Comment t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(Comment t) {
		sesfact.getCurrentSession().delete(t);
	}

	public Comment findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
