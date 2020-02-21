package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CommentDao;
import com.revature.model.Comment;

/**
 * @author TeamLeo
 * This class is the only class that can communicate with the CommentDao class inside of the Dao layer.
 * Service layer for the Comment model.
 */
@Service
public class CommentService {
	
	/**
	 * CommentDao instantiation.
	 */
	private CommentDao cd;

	/**
	 * Automatically creates an association
	 * to the CommentDao
	 * @param cd
	 */
	@Autowired
	public void setCd(CommentDao cd) {
		this.cd = cd;
	}
	
	/**
	 * Reads all comments in the database
	 * @return findAll()
	 */
	public List<Comment> readAll() {
		return cd.findAll();
	}
	
	/**
	 * Returns Comment by id
	 * @param id
	 * @return findById(id)
	 */
	public Comment findById(int id) {
		return cd.findById(id);
	}
	
	/**
	 * Updates a comment
	 * @param comment
	 * @return update(comment)
	 */
	public Comment update(Comment comment) {
		return cd.update(comment);
	}
	
	/**
	 * Inserts a comment into the database
	 * @param comment
	 * @return insert(comment)
	 */
	public Comment insert(Comment comment) {
		return cd.insert(comment);
	}
	
	/**
	 * Deletes a comment
	 * @param comment
	 */
	public void delete(Comment comment) {
		cd.delete(comment);
	}

}
