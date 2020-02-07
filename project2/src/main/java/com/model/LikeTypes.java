package com.model;

public class LikeTypes {

	private int likeTypeId;
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
