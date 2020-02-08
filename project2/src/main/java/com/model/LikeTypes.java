package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "like_types")
public class LikeTypes {

	@Id
	@Column(name = "like_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeTypeId;
	
	@Column(name = "like_type")
	private String likeType;

	public int getLikeTypeId() {
		return likeTypeId;
	}

	public void setLikeTypeId(int likeTypeId) {
		this.likeTypeId = likeTypeId;
	}

	public String getLikeType() {
		return likeType;
	}

	public void setLikeType(String likeType) {
		this.likeType = likeType;
	}

	public LikeTypes(int likeTypeId, String likeType) {
		super();
		this.likeTypeId = likeTypeId;
		this.likeType = likeType;
	}

	@Override
	public String toString() {
		return "LikeTypes [likeTypeId=" + likeTypeId + ", likeType=" + likeType + "]";
	}

}
