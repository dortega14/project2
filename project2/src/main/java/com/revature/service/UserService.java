package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.model.User;
/**
 * 
 * @author TeamLeo
 * <br>
 * <br>
 * This class is the only class that can communicate with the UserDao class inside of the Dao layer.
 * 
 *
 */
@Service
public class UserService {
	
	private UserDao ud;
	
	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public List<User> readAll() {
		return ud.findAll();
	}
	
	public User findById(int id) {
		return ud.findById(id);
	}

	public User update(User user) {
		return ud.update(user);
	}

	public User insert (User user) {
		return ud.insert(user);
	}
	
	public void delete(int id) {
		ud.delete(id);
	}

}
