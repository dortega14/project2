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
	
	/**
	 * LikeDao instantiation
	 */
	private LikeDao ld;

	/**
	 * Automatically creates an association
	 * to the LikeDao
	 * @param ld
	 */
	@Autowired
	public void setLd(LikeDao ld) {
		this.ld = ld;
	}
	
	/**
	 * Returns all likes
	 * @return findAll()
	 */
	public List<Like> readAll() {
		return ld.findAll();
	}
	
	/**
	 * Returns like by id
	 * @param id
	 * @return findById(id)
	 */
	public Like findById(int id) {
		return ld.findById(id);
	}
	
	/**
	 * Updates a like
	 * @param like
	 * @return update(like)
	 */
	public Like update(Like like) {
		return ld.update(like);
	}
	
	/**
	 * Inserts a Like
	 * @param like
	 * @return(like)
	 */
	public Like insert(Like like) {
		return ld.insert(like);
	}
	
	/**
	 * Deletes a like
	 * @param like
	 */
	public void delete(Like like) {
		ld.delete(like);
	}

}
