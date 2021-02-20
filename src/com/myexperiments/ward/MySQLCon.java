package com.myexperiments.ward;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MySQLCon {
	static Connection con;
	ResultSet rs;

	public MySQLCon(String User, String Password) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guttenberg", User, Password);
		// here sonoo is the database name, root is the username and root is the
		// password

	}

	public ResultSet query(String query) throws SQLException {
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
	}

	public void list() throws SQLException {

		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		con.close();

	}

}
