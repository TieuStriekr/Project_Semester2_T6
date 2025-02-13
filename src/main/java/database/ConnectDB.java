package database;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectDB {
	private static Connection con = null;
	private static String url = "jdbc:sqlserver://";
	private static String serverName = "LAPTOP-9CHM06L4\\SQLEXPRESS";
	private static String portNumber = "1433";
	private static String databaseName = "medicineStore";
	private static String username ="sa";
	private static String password = "calmeSasRus1";
	
	public static String getUrl() {
		return url + serverName + ":" + portNumber
				+ "; databaseName=" + databaseName
				+ "; user=" + username
				+ "; password=" +password;
	}
	
	public static Connection getCon() {
		try {
			con = DriverManager.getConnection(getUrl());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't connect to database");
		}
		return con;
	}
}
