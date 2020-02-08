package com.driver;

import com.dao.UserDao;
import com.model.Category;
import com.service.CategoryService;
import com.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		
		CategoryService.insert(new Category(0, "Breakfast"));
		CategoryService.insert(new Category(0, "Lunch"));
		CategoryService.insert(new Category(0, "Dinner"));
	}

}
