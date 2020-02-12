package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Category;
import com.revature.model.LikeType;
import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.CategoryService;
import com.revature.service.LikeTypeService;
import com.revature.service.PostService;
import com.revature.service.UserService;

public class Driver {
	
	public static ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
	
	static UserService us = ac.getBean(UserService.class);

	public static void main(String[] args) {
//		initializeCategory();
//		initializeLikeType();
		initializeUser();
//		initializePost();
//		deleteUser();
//		deletePost();
	}

	private static void initializeCategory() {
		CategoryService cs = new CategoryService();
		cs.insert(new Category(0, "Breakfast"));
		cs.insert(new Category(0, "Lunch"));
		cs.insert(new Category(0, "Dinner"));
	}

	private static void initializeLikeType() {
		LikeTypeService lts = new LikeTypeService();
		lts.insert(new LikeType(0, "Tasty"));
		lts.insert(new LikeType(0, "Looks good"));
		lts.insert(new LikeType(0, "Needs salt"));
	}

	private static void initializeUser() {
//		UserService us = new UserService();
//		us.insert(new User(0, "dave14", "gonoles", "David", "Ortega", "dave.ort14@gmail.com"));
		us.insert(new User(0, "condog", "iamconnor", "Connor", "Casey", "connorcaseyc@gmail.com"));
	}

	private static void initializePost() {
		PostService ps = new PostService();
		CategoryService cs = new CategoryService();
		UserService us = new UserService();
		ps.insert(new Post(0, "Fajitas", null, "Cook", "ingredients", cs.findById(2),
				us.findById(3)));
	}
	
	private static void deleteUser() {
		
	}
	
	private static void deletePost() {
		PostService ps = new PostService();
		ps.delete(3);
	}

}
