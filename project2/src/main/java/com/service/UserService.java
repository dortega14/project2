package com.service;

import com.dao.UserDao;
import com.model.User;

public class UserService {
	
	public static int insert(String username, String password, String firstName, String lastName, String email) {
		return new UserDao().insert(new User(0, username, password, firstName, lastName, email));
	}
	
	public static int update(String username, String password) {
		return new UserDao().update(new User(username, password));
	}
	
	public static int delete(String username) {
		return new UserDao().delete(new User(username));
	}

}
