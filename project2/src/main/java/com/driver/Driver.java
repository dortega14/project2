package com.driver;

import com.dao.UserDao;
import com.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		
		UserService.insert("dave14", "password", "David", "Ortega", "dave.ort14@gmail.com");
		System.out.println(new UserDao().readAll());
		
		UserService.update("dave14", "password2");
		System.out.println(new UserDao().readAll());
		
		UserService.delete("dave14");
		System.out.println(new UserDao().readAll());
	}

}
