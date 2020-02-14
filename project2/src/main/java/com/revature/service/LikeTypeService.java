package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LikeTypeDao;
import com.revature.model.LikeType;

@Service
public final class LikeTypeService {
	
	private LikeTypeDao ltd;

	@Autowired
	public void setLtd(LikeTypeDao ltd) {
		this.ltd = ltd;
	}
	
	public List<LikeType> readAll() {
		return ltd.findAll();
	}
	
	public LikeType findById(int id) {
		return ltd.findById(id);
	}
	
	public LikeType update(LikeType lt) {
		return ltd.update(lt);
	}
	
	public LikeType insert(LikeType lt) {
		return ltd.insert(lt);
	}
	
	public void delete(LikeType lt) {
		ltd.delete(lt);
	}

}
