package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.YouTubeLinkDao;
import com.revature.model.YouTubeLink;

/**
 * 
 * @author TeamLeo
 * <br>
 * <br>
 * This class is the only class that can communicate with the YouTubeLinkDao class inside of the Dao layer.
 * 
 *
 */
@Service
public class YouTubeLinkService {
	
	private YouTubeLinkDao ytld;

	@Autowired
	public void setYtld(YouTubeLinkDao ytld) {
		this.ytld = ytld;
	}
	
	public List<YouTubeLink> readAll() {
		return ytld.findAll();
	}
	
	public YouTubeLink findById(int id) {
		return ytld.findById(id);
	}
	
	public YouTubeLink update(YouTubeLink ytl) {
		return ytld.update(ytl);
	}
	
	public YouTubeLink insert(YouTubeLink ytl) {
		return ytld.insert(ytl);
	}
	
	public void delete(int id) {
		ytld.delete(id);
	}

}
