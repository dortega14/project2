package com.driver;

import com.dao.CategoryDao;
import com.dao.LikeTypeDao;
import com.dao.PostDao;
import com.dao.UserDao;
import com.model.Category;
import com.model.LikeType;
import com.model.Post;
import com.model.User;

public class Driver {

	static int si = 10;
	public static void main(String[] args) {
//		initializeCategory();
//		initializeLikeType();
		initializeUser();
//		initializePost();
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

	private static void initializePost() {
		PostDao pd = new PostDao();
		pd.insert(new Post(0, "Fajitas", null,  null, "Cook", "ingredients", null, null));
	}

}
