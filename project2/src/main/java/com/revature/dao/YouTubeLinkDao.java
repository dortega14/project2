package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.YouTubeLink;

/**
 * @author TeamLeo
 * Contains the CRUD methods for the YouTubeLink Model.
 */
@Repository
@Transactional
public class YouTubeLinkDao {

	private SessionFactory sesfact;
	
	@Autowired
	public YouTubeLinkDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	public List<YouTubeLink> findAll() {
		return sesfact.getCurrentSession().createQuery("from YouTubeLink", YouTubeLink.class).list();
	}

	public YouTubeLink findById(int id) {
		return sesfact.getCurrentSession().get(YouTubeLink.class, id);
	}

	public YouTubeLink update(YouTubeLink t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public YouTubeLink insert(YouTubeLink t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(YouTubeLink t) {
		sesfact.getCurrentSession().delete(t);
		
	}

	public YouTubeLink findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
