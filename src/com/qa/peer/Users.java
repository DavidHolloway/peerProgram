package com.qa.peer;

import java.sql.*;

public class Users {

	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost:3306/inventorymanagmentsys?useSSL=false";// changed from gamedb
																									// to game -->name
																									// of my database
	public final String USER = "root";
	public final String PASS = "root";

	Connection conn = null;
	Statement stmt = null;

	public void connect() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting connection to database");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// System.out.println("connected!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createUser(int userID, String userName, String password, String firstName, String lastName) {
		String create = "INSERT INTO " + "users" + " VALUES(" + userID + ",'" + userName + "','" + password + "','"
				+ firstName + "','" + lastName + "')";
		try {
			stmt.executeUpdate(create);
			System.out.println("Record created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readUser() {
		String read = "SELECT userID,userName,password,firstName,lastName from users";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int i1 = rs.getInt("userID");
				String user1 = rs.getString("userName");
				String pass = rs.getString("password");
				String first = rs.getString("firstName");
				String last = rs.getString("lastName");
				System.out.println("User ID: " + i1 + "userName: " + user1 + "Password" + pass + "First Name: " + first
						+ "Last Name: " + last);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			stmt.executeQuery(read);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void updateUser(int ID, String name) {

		String update = "update users" + " set userName='" + name + "' where userID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("Record updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
	}

	public void deleteUser(int ID) {

		String delete = "DELETE FROM " + "users" + " WHERE userID=" + ID;
		try {
			stmt.executeUpdate(delete);
			System.out.println("record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
