package com.myexperiments.ward;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import com.mysql.cj.jdbc.Driver;

/**
 * Select Statement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class SelectStatementExample {

	String user = "root";
	String password = "Rs232x25??";
	String connectionstring = "jdbc:mariadb://localhost:3306/ward?useSSL=false";
	static Connection Queryconnection;

	public SelectStatementExample() {

		/*
		 * try { Class.forName("com.mariadb.jdbc.Driver"); } catch
		 * (ClassNotFoundException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		// using try-with-resources to avoid closing resources (boilerplate code)

		// Step 1: Establishing a Connection
		try {
			Queryconnection = DriverManager.getConnection(connectionstring, user, password);
		} catch (SQLException e) {
			printSQLException(e);

		}
	}

	ResultSet doQuery(String QUERY) {

		// Step 2:Create a statement using connection object
		try {
			Statement stmt = Queryconnection.createStatement();

			// Step 3: Execute the query or update query
			ResultSet rs = stmt.executeQuery(QUERY);

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
			return rs;

		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return null;

	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	private static void insertRowInResultSetObject(String QUERY) {
		// String QUERY = "select id,name,email,country,password from Users where id =
		// 1";
		try {

			// (Connection connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false",
			// "root", "root");
			// Step 2:Create a statement using connection object
			Statement stmt = Queryconnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// Step 3: Execute the query or update query
			ResultSet uprs = stmt.executeQuery(QUERY);

			uprs.moveToInsertRow();
			uprs.updateInt(1, 25);
			uprs.updateString(2, "b");
			uprs.updateString(3, "b@gmail.com");
			uprs.updateString(4, "India");
			uprs.updateString(5, "secret");
			uprs.insertRow();
			uprs.beforeFirst();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	private static void batchUpdate(Connection Queryconnection, String QUERY) {
		try {
			// (Connection connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false",
			// "root", "root");
			// Step 2:Create a statement using connection object
			Statement statement = Queryconnection.createStatement();
			{
				Queryconnection.setAutoCommit(false);
				statement.addBatch("INSERT INTO Users VALUES (13, 'Pramod', 'pramod@gmail.com', 'India', '123');");
				statement.addBatch("INSERT INTO Users VALUES (14, 'A', 'a@gmail.com', 'India', '123');");
				statement.addBatch("INSERT INTO Users VALUES (15, 'B', 'b@gmail.com', 'India', '123');");
				statement.addBatch("INSERT INTO Users VALUES (16, 'C', 'c@gmail.com', 'India', '123');");
				statement.addBatch("INSERT INTO Users VALUES (17, 'D', 'd@gmail.com', 'India', '123');");
				int[] updateCounts = statement.executeBatch();
				System.out.println(Arrays.toString(updateCounts));
				Queryconnection.commit();
			}
		} catch (BatchUpdateException batchUpdateException) {
			printBatchUpdateException(batchUpdateException);
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public static void printBatchUpdateException(BatchUpdateException b) {

		System.err.println("----BatchUpdateException----");
		System.err.println("SQLState:  " + b.getSQLState());
		System.err.println("Message:  " + b.getMessage());
		System.err.println("Vendor:  " + b.getErrorCode());
		System.err.print("Update counts:  ");
		int[] updateCounts = b.getUpdateCounts();

		for (int i = 0; i < updateCounts.length; i++) {
			System.err.print(updateCounts[i] + "   ");
		}
	}

}