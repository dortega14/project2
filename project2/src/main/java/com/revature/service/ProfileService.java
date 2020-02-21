package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ProfileDao;
import com.revature.model.Profile;

/**
 * @author TeamLeo
 * This class is the only class that can communicate with the ProfileDao class inside of the Dao layer.
 * Service layer for the Profile model.
 */
@Service
public class ProfileService {
	
	/**
	 * Initializes ProfileDao
	 */
	private ProfileDao pd;

	/**
	 * Automatically creates associations to
	 * the ProfileDao
	 * @param pd
	 */
	@Autowired
	public void setPd(ProfileDao pd) {
		this.pd = pd;
	}
	
	/**
	 * Returns all Profiles
	 * @return findAll()
	 */
	public List<Profile> readAll() {
		return pd.findAll();
	}
	
	/**
	 * Returns profile by id
	 * @param id
	 * @return findById(id)
	 */
	public Profile findById(int id) {
		return pd.findById(id);
	}
	
	/**
	 * Updates profile 
	 * @param prof
	 * @return update(prof)
	 */
	public Profile update(Profile prof) {
		return pd.update(prof);
	}
	
	/**
	 * Inserts profile  
	 * @param prof
	 * @return insert(prof)
	 */
	public Profile insert(Profile prof) {
		return pd.insert(prof);
	}
	
	/**
	 * Deletes a profile
	 * @param prof
	 */
	public void delete(Profile prof) {
		pd.delete(prof);
	}

}
