//package com.qa.peer;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class SqlConnect {
//	
//	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	public final String DB_URL = "jdbc:mysql://localhost:3306/inventorymanagmentsys?useSSL=false";// changed from gamedb
//																									// to game -->name
//																									// of my database
//	public final String USER = "root";
//	public final String PASS = "root";
//
//	Connection conn = null;
//	Statement stmt = null;
//
//	public void connect() {
//		try {
//			Class.forName(JDBC_DRIVER);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Starting connection to database");
//
//		try {
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			// System.out.println("connected!!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
//}
