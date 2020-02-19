package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Category;
import com.revature.model.LikeType;
import com.revature.model.Post;
import com.revature.model.User;
import com.revature.model.YouTubeLink;
import com.revature.service.CategoryService;
import com.revature.service.LikeTypeService;
import com.revature.service.PostService;
import com.revature.service.UserService;
import com.revature.service.YouTubeLinkService;

public class Driver {

	public static ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");

	static UserService us = ac.getBean(UserService.class);
	static LikeTypeService lts = ac.getBean(LikeTypeService.class);
	static CategoryService cs = ac.getBean(CategoryService.class);
	static PostService ps = ac.getBean(PostService.class);
	static YouTubeLinkService ytls = ac.getBean(YouTubeLinkService.class);

	public static void main(String[] args) {

//		initializeCategory();
//		initializeLikeType();
//		initializeUser();
		initializePost();
//		deleteUser();
//		viewAllUsers();
//		findUserByUsername();
//		initializePostWithYtLink();
//		initializeYtLink();
	}

	private static void initializeCategory() {
		cs.insert(new Category(0, "Breakfast"));
		cs.insert(new Category(0, "Lunch"));
		cs.insert(new Category(0, "Dinner"));
	}

	private static void initializeLikeType() {
		lts.insert(new LikeType(0, "Tasty"));
		lts.insert(new LikeType(0, "Looks good"));
		lts.insert(new LikeType(0, "Needs salt"));
	}

	private static void initializeUser() {
		us.insert(new User(0, "dave14", "gonoles", "David", "Ortega", "dave.ort14@gmail.com"));
		us.insert(new User(0, "condog", "iamconnor", "Connor", "Casey", "connorcaseyc@gmail.com"));
		us.insert(new User(0, "palkrom", "Bigchungus492", "Kyle", "Welch", "palkia.welch@gmail.com"));
	}

	private static void initializePost() {
//		ps.insert(new Post(0, "Fajitas", null, "Cook", "ingredients", cs.findById(2),
//				us.findById(1)));
		ps.insert(new Post(0, "Tacos", null, "Cook the dang thing", "tortilla, meat, cheese", cs.findById(2),
				us.findById(1), ytls.findById(2)));
	}

	private static void initializePostWithYtLink() {
		ytls.extractYT(new Post(0, "Fajitas", null, "Cook with khttp://youtube.com/watch?v=jJ2qlKLYKxc&t=54",
				"ingredients", cs.findById(2), us.findById(1)));
	}

	private static User findUserByUsername() {
		return us.findByUsername("palkrom");
	}

	private static void viewAllUsers() {
		System.out.println(us.readAll());
	}
	
	private static void initializeYtLink() {
		ytls.insert(new YouTubeLink(0, "http://youtube.com/watch?v=jJ2qlKLYKxc&t=54", 54));
	}

}
