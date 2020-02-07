package com.dao;

import java.util.List;

public interface DaoContract<T> {
	
		//create
		int insert(T t);
		
		//read
		List<T> readAll();
		
		//update
		int update(T t);
		
		//delete
		int delete(T t);
		

}
