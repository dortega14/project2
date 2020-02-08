package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.driver.Driver;
import com.driver.Log4j;
import com.model.User;

public class UserDao implements DaoContract<User> {

	@Override
	public int insert(User t) {
		
		return 0;
	}

	@Override
	public List<User> readAll() {
		return null;
	}

	@Override
	public int update(User t) {
		return 0;
	}

	@Override
	public int delete(User t) {
		
		return 0;
	}

}
