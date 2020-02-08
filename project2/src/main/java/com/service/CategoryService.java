package com.service;

import com.dao.CategoryDao;
import com.model.Category;

public class CategoryService {
	
	public static Category insert(Category category) {
		return new CategoryDao().insert(category);
	}

}
