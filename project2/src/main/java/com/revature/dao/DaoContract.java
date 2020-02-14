package com.revature.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DaoContract<T> {

	List<T> findAll();

	T findById(int id);

	T update(T t);

	T insert(T t);

	void delete(T t);

	T findByName(String name);

}
