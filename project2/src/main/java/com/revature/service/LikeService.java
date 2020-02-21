package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LikeDao;
import com.revature.model.Like;

/**
 * @author TeamLeo
 * This class is the only class that can communicate with the LikeDao class inside of the Dao layer.
 * Service layer for the Like model.
 */
@Service
public class LikeService {
	
	private LikeDao ld;

	@Autowired
	public void setLd(LikeDao ld) {
		this.ld = ld;
	}
	
	public List<Like> readAll() {
		return ld.findAll();
	}
	
	public Like findById(int id) {
		return ld.findById(id);
	}
	
	public Like update(Like like) {
		return ld.update(like);
	}
	
	public Like insert(Like like) {
		return ld.insert(like);
	}
	
	public void delete(Like like) {
		ld.delete(like);
	}

}
