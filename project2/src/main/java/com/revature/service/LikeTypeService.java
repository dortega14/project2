package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LikeTypeDao;
import com.revature.model.LikeType;

/**
 * @author TeamLeo
 * Service layer for the LikeType model.
 */
@Service
public class LikeTypeService {
	
	/**
	 * Instantiating LikeTypeDao
	 */
	private LikeTypeDao ltd;

	/**
	 * Automatically creates association
	 * to LikeTypeDao
	 * @param ltd
	 */
	@Autowired
	public void setLtd(LikeTypeDao ltd) {
		this.ltd = ltd;
	}
	
	/**
	 * Returns all LikeTypes
	 * @return findAll()
	 */
	public List<LikeType> readAll() {
		return ltd.findAll();
	}
	
	/**
	 * Return LikeType by id
	 * @param id
	 * @returns findById(id)
	 */
	public LikeType findById(int id) {
		return ltd.findById(id);
	}
	
	/**
	 * Updates LikeType
	 * @param lt
	 * @return update(lt)
	 */
	public LikeType update(LikeType lt) {
		return ltd.update(lt);
	}
	
	/**
	 * Inserts LikeType
	 * @param lt
	 * @return insert(lt)
	 */
	public LikeType insert(LikeType lt) {
		return ltd.insert(lt);
	}
	
	/**
	 * Deletes LikeType
	 * @param lt
	 */
	public void delete(LikeType lt) {
		ltd.delete(lt);
	}

}
