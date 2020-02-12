package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.YouTubeLink;

@Repository
@Transactional
public class YouTubeLinkDao implements DaoContract<YouTubeLink> {

	private SessionFactory sesfact;
	
	@Autowired
	public YouTubeLinkDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	@Override
	public List<YouTubeLink> findAll() {
		return sesfact.openSession().createQuery("from yt_links", YouTubeLink.class).list();
	}

	@Override
	public YouTubeLink findById(int id) {
		return sesfact.openSession().get(YouTubeLink.class, id);
	}

	@Override
	public YouTubeLink update(YouTubeLink t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public YouTubeLink insert(YouTubeLink t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public YouTubeLink findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
