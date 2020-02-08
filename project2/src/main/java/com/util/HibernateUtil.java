package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class HibernateUtil {

	private static SessionFactory sesfact;

	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		return config.buildSessionFactory();

	}

	public static SessionFactory getSessionFactory() {
		if (sesfact == null) {
			sesfact = buildSessionFactory();
		}
		return sesfact;
	}

//	static {
//		try {
//		Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static Connection connect() {
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(
//					System.getenv("URL2"),
//					System.getenv("USER"),
//					System.getenv("PASS"));
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	return conn;
//	}

}
