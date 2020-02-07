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
import com.util.ConnectionUtil;

public class UserDao implements DaoContract<User> {

	@Override
	public int insert(User t) {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "insert into users (id, username, password, first_name, last_name, email) "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getUserId());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getFirstName());
			ps.setString(5, t.getLastName());
			ps.setString(6, t.getEmail());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			Log4j.log.info("Creating a new user failed.");
		}
		return 0;
	}

	@Override
	public List<User> readAll() {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select * from users";
			List<User> list = new ArrayList<>();
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			Log4j.log.warn("Read users failed.");
		}
		return null;
	}

	@Override
	public int update(User t) {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "update users set password = ? where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			return ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			Log4j.log.warn("Updating a password failed.");
		}
		return 0;
	}

	@Override
	public int delete(User t) {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "delete from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			Log4j.log.warn("Deleting a user failed.");
		}
		return 0;
	}

}
