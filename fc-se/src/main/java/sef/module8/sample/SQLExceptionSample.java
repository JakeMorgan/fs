package sef.module8.sample;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLExceptionSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String username = "sa";
			String password = "";
			DriverManager.registerDriver (new Driver());
			String url = "jdbc:h2:tcp://localhost/~/test";
            Connection cn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successfully established! \n");
			
			cn.close();
		}catch(SQLException e){
			System.out.println("SQLException");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("Exception");
		}

	}

}
