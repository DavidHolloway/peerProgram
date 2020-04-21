package com.qa.peer;

import java.sql.*;

public class Products {

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

	public void createProduct(int productID, String productName, double price, int stock) {
		String create = "INSERT INTO " + "products" + " VALUES(" + productID + ",'" + productName +
				"'," + price + ","+  stock+ ")";
		try {
			stmt.executeUpdate(create);
			System.out.println("Product added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readProduct() {
		String read = "SELECT productID,productName,price,stock from products";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int i1 = rs.getInt("productID");
				String prod = rs.getString("productName");
				Double p = rs.getDouble("price");
				int s = rs.getInt("stock");
				System.out.println("Product ID: " + i1 + "productName: " + prod + "Price" + p + "Stock: " + s);

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

	public void updateProduct(int ID, String name) {

		String update = "update products" + " set productName='" + name + "' where productID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("product updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
	}

	public void deleteProduct(int ID) {

		String delete = "DELETE FROM " + "products" + " WHERE productID=" + ID;
		try {
			stmt.executeUpdate(delete);
			System.out.println("product deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
