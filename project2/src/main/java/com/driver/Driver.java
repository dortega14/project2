package com.driver;

import com.dao.CategoryDao;
import com.dao.LikeTypeDao;
import com.dao.UserDao;
import com.model.Category;
import com.model.LikeType;
import com.model.User;

public class Driver {
	
	public static void main(String[] args) {
//		initializeCategory();
//		initializeLikeType();
		initializeUser();
	}
	
	private static void initializeCategory() {
		CategoryDao cd = new CategoryDao();
		cd.insert(new Category(0, "Breakfast"));
		cd.insert(new Category(0, "Lunch"));
		cd.insert(new Category(0, "Dinner"));
	}
	
	private static void initializeLikeType() {
		LikeTypeDao ltd = new LikeTypeDao();
		ltd.insert(new LikeType(0, "Tasty"));
		ltd.insert(new LikeType(0, "Looks good"));
		ltd.insert(new LikeType(0, "Needs salt"));
	}
	
	private static void initializeUser() {
		UserDao ud = new UserDao();
		ud.insert(new User(0, "dave14", "gonoles", "David", "Ortega", "dave.ort14@gmail.com"));
	}

}
