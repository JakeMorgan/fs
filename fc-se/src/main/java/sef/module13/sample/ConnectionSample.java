package sef.module13.sample;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSample {

	// This source code tries to establish a connection to a MySQL server
	// and displays a message concerning the error if connection fails
	public static void main(String[] args) {
		Connection cn = null;
		try {
			String username = "sa";
			String password = "";
			DriverManager.registerDriver (new Driver());
			String url = "jdbc:h2:tcp://localhost/~/test";
			
			cn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection successfully established! \n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
