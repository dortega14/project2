package com.model;

import java.sql.Blob;

public class Profile {

	private int profileId, userId;
	private String bio;
	private Blob coverImage;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Blob getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(Blob coverImage) {
		this.coverImage = coverImage;
	}

	public Profile(int profileId, int userId, String bio, Blob coverImage) {
		super();
		this.profileId = profileId;
		this.userId = userId;
		this.bio = bio;
		this.coverImage = coverImage;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", userId=" + userId + ", bio=" + bio + ", coverImage=" + coverImage
				+ "]";
	}

}
