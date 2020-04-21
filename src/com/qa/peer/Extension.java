package com.qa.peer;

//import java.sql.*;
import java.util.Scanner;
//import com.qa.peer.Users;

public class Extension {

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

//	public void createUser(int userID, String userName, String password, String firstName, String lastName) {
//		String create = "INSERT INTO " + "users" + " VALUES(" + userID + ",'" + userName + "','" + password + "','"
//				+ firstName + "','" + lastName + "')";
//		try {
//			stmt.executeUpdate(create);
//			System.out.println("Record created");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public void readUser() {
//		String read = "SELECT userID,userName,password,firstName,lastName from users";
//		ResultSet rs = null;
//		try {
//			rs = stmt.executeQuery(read);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			while(rs.next()) {
//				int i1 = rs.getInt("userID");
//				String user1 = rs.getString("userName");
//				String pass = rs.getString("password");
//				String first = rs.getString("firstName");
//				String last = rs.getString("lastName");
//				System.out.println("User ID: " + i1 + "userName: " + user1 + "Password" + pass+ "First Name: "+first + "Last Name: " + last);
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		try {
////			stmt.executeQuery(read);
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//	}
//
//	public void updateUser(int ID, String name) {
//
//		String update = "update users" + " set userName='" + name + "' where userID=" + ID;
//		try {
//			stmt.executeUpdate(update);
//			System.out.println("Record updated");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("error!");
//			e.printStackTrace();
//		}
//	}
//
//	public void deleteUser(int ID) {
//
//		String delete = "DELETE FROM " + "users" + " WHERE userID=" + ID;
//		try {
//			stmt.executeUpdate(delete);
//			System.out.println("record deleted");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		//Extension ext = new Extension();
//		Users ext = new Users();
//		ext.connect();
		// a.connect();
		// a.createUser("users", 0, "Dave1", "12345", "Davey", "Holloway");
//		SqlConnect con = new SqlConnect();
//		con.c

		//con.connect();
		int userID = 0;
		int productID = 0;
		// ext.createUser("users", 0, "Dave1", "12345", "Davey", "Holloway");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select a table:\nUsers[1] Products[2] Orders[3]\n");
		int table = sc.nextInt();
		System.out.println();
		sc.nextLine();
		

		switch (table) {
		case 1:
			Users ext = new Users();
			ext.connect();
			System.out.println("Please Select an option: Create[1], Read[2], Update[3], Delete[4]");
			int u = sc.nextInt();
			System.out.println();
			sc.nextLine();
			switch(u) {
			case 1:
				System.out.println("Please enter your username:");
				String user = sc.nextLine();
				System.out.println("\nPlease enter a password:");
				String pass = sc.nextLine();
				System.out.println("\nPlease enter your first name:");
				String fName = sc.nextLine();
				System.out.println("Please enter your last name:\n");
				String lName = sc.nextLine();
				ext.createUser(userID, user, pass, fName, lName);
				break;
			case 2:
				ext.readUser();
				break;
			case 3:
				System.out.println("Please enter your userID: ");
				int id = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("\nPlease enter the new username: ");
				String name = sc.nextLine();
				ext.updateUser(id, name);
				break;
			case 4:
				System.out.println("Please enter your userID: ");
				int idDel = sc.nextInt();
				ext.deleteUser(idDel);
				break;			
				
			}
			
			break;
		case 2:
			Products p = new Products();
			p.connect();
			System.out.println("Please Select an option: Create[1], Read[2], Update[3], Delete[4]");
			int p1 = sc.nextInt();
			System.out.println();
			sc.nextLine();
			switch(p1) {
			case 1:
				System.out.println("Please enter product name:");
				String prod = sc.nextLine();
				System.out.println("\nPlease enter the price:");
				double pr = sc.nextDouble();
				System.out.println();
				sc.nextLine();				
				System.out.println("\nPlease enter the amount of stock:");
				int st = sc.nextInt();
				System.out.println();
				sc.nextLine();
				p.createProduct(productID, prod, pr, st);
				break;
			case 2:
				p.readProduct();
				break;
			case 3:
				System.out.println("Please enter your productID: ");
				int id = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("\nPlease enter the new product name: ");
				String name = sc.nextLine();
				p.updateProduct(id, name);
				break;
			case 4:
				System.out.println("Please enter your productID: ");
				int idDel = sc.nextInt();
				p.deleteProduct(idDel);
				break;			
//					System.out.println("Please enter your username:\n");
//					String user = sc.nextLine();
//					System.out.println("Please enter a password:\n");
//					String pass = sc.nextLine();
//					System.out.println("Please enter your first name:\n");
//					String fName = sc.nextLine();
//					System.out.println("Please enter your last name:\n");
//					String lName = sc.nextLine();
//					ext.createUser(table, userID, user, pass, fName, lName);
			}
			break;
		case 3:
			break;
		default:
			System.out.println("Please enter 1, 2 or 3...");
		}

	}
}
