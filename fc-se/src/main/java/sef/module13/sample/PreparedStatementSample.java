package sef.module13.sample;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//	This class demonstrates the use of PreparedStatements
public class PreparedStatementSample {

	public static void main(String[] args) {
		try{
			String username = "sa";
			String password = "";
			DriverManager.registerDriver (new Driver());
			String url = "jdbc:h2:tcp://localhost/~/test";
            Connection cn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successfully established! \n");
			
			PreparedStatement pStmt = cn.prepareStatement("select * from Account where UPPER(LAST_NAME) = ? ");
			
			//	Change parameter to any keyword desired, if a record
			// 	matches the query then it will be displayed
			pStmt.setString(1,"DOE");
			
			ResultSet rs = pStmt.executeQuery();
			
			System.out.println("Printing Query results:");
			while(rs.next()){
				System.out.println(rs.getString(1) + " - " + 
							rs.getString(2) + " - " + 
							rs.getString(3) + " - " + 
							rs.getString(4));
					
			}
			
			cn.close();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

}
