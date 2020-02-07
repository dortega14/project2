package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static {
		try {
		Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					System.getenv("URL2"),
					System.getenv("USER"),
					System.getenv("PASS"));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	return conn;
	}

}
