package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ProfileDao;
import com.revature.model.Profile;

/**
 * 
 * @author TeamLeo
 * <br>
 * <br>
 * This class is the only class that can communicate with the ProfileDao class inside of the Dao layer.
 * 
 *
 */
@Service
public class ProfileService {
	
	private ProfileDao pd;

	@Autowired
	public void setPd(ProfileDao pd) {
		this.pd = pd;
	}
	
	public List<Profile> readAll() {
		return pd.findAll();
	}
	
	public Profile findById(int id) {
		return pd.findById(id);
	}
	
	public Profile update(Profile prof) {
		return pd.update(prof);
	}
	
	public Profile insert(Profile prof) {
		return pd.insert(prof);
	}
	
	public void delete(int id) {
		pd.delete(id);
	}

}
