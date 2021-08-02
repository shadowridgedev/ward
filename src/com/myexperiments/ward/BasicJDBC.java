package com.myexperiments.ward;

import java.sql.*;

public class BasicJDBC {
	Connection conn;
	String table;
	String username;
	String password;
	String fields;
	String url;
	String data;

	public BasicJDBC(String table, String username, String password, String url, String fields)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		try {

			this.table = table;
			this.username = username;
			this.password = password;
			this.url = url;
			this.fields = fields;

//			Class<?> obj = 
			Class.forName("com.mysql.jdbc.Driver"); // .newInstance();
//			String obj = null;
//			System.out.println("The class of " + obj + "            is " + obj.getClass().getName());
//	String url = "jdbc:mysql://localhost/coffeebreak";
			try {

				conn = DriverManager.getConnection(url, "username", "password");
			}

			/*
			 * catch (ClassNotFoundException ex) { System.out.println(ex.getMessage()); }
			 * catch (IllegalAccessException ex) { System.out.println(ex.getMessage()); }
			 * catch (InstantiationException ex) { System.out.println(ex.getMessage()); }
			 */
			catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		} finally {
		}

	}

	private void doTests() {
		doSelectTest(data);

		doInsertTest(data);
		doSelectTest(data);
		doUpdateTest(data);
		doSelectTest(data);
		doDeleteTest(data);
		doSelectTest(data);
	}

	private void doSelectTest(String data) {
		System.out.println("[OUTPUT FROM SELECT]");
		String query = "SELECT COF_NAME, PRICE FROM COFFEES";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String s = rs.getString("COF_NAME");
				float n = rs.getFloat("PRICE");
				System.out.println(s + "   " + n);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doInsertTest(String data) {
		System.out.print("\n[Performing INSERT] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO COFFEES " + "VALUES ('BREAKFAST BLEND', 200, 7.99, 0, 0)");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doUpdateTest(String data) {
		System.out.print("\n[Performing UPDATE] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE COFFEES SET PRICE=4.99 WHERE COF_NAME='BREAKFAST BLEND'");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doDeleteTest(String data) {
		System.out.print("\n[Performing DELETE] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM COFFEES WHERE COF_NAME='BREAKFAST BLEND'");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
}