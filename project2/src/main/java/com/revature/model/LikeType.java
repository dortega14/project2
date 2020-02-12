package com.revature.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "like_types")
public class LikeType {

	@Id
	@Column(name = "like_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeTypeId;

	@Column(name = "like_type")
	private String likeType;

	@OneToMany(mappedBy = "likeLikeType", fetch = FetchType.LAZY)
	private Set<Like> likeTypeLike;

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

	public Set<Like> getLikeTypeLike() {
		return likeTypeLike;
	}

	public void setLikeTypeLike(Set<Like> likeTypeLike) {
		this.likeTypeLike = likeTypeLike;
	}

	public LikeType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeType(int likeTypeId, String likeType) {
		super();
		this.likeTypeId = likeTypeId;
		this.likeType = likeType;
	}

	public LikeType(int likeTypeId, String likeType, Set<Like> likeTypeLike) {
		super();
		this.likeTypeId = likeTypeId;
		this.likeType = likeType;
		this.likeTypeLike = likeTypeLike;
	}

	@Override
	public String toString() {
		return "LikeType [likeTypeId=" + likeTypeId + ", likeType=" + likeType + "]";
	}

}
