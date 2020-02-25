package sef.module13.sample;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertSample {

	public static void main(String[] args) {
		try{
			String username = "sa";
			String password = "";
			DriverManager.registerDriver (new Driver());
			String url = "jdbc:h2:tcp://localhost/~/test";
            Connection cn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successfully established! \n");
			
			PreparedStatement pStmt 
				= cn.prepareStatement("insert into Account (FIRST_NAME, LAST_NAME, E_MAIL) VALUES (?,?,?)");
			
			//	Change parameter to any keyword desired, if a record
			// 	matches the query then it will be displayed
			pStmt.setString(1,"Clark");
			pStmt.setString(2,"Kent");
			pStmt.setString(3,"clark.kent@dailyplanet.com");
			
			int rows = pStmt.executeUpdate();
			cn.commit();	
			System.out.println(rows + " added!");
			
			cn.close();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
}
