package com.revature.model;

import com.revature.model.User;

public class PaginateReq {

	private int offset;
	private int limit;
	private User user;

	public int getOffset() {
		return this.offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User u) {
		this.user = u;
	}

	public PaginateReq() {
		super();
	}

	public PaginateReq(int offset, int limit, User user) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.user = user;
	}

}
