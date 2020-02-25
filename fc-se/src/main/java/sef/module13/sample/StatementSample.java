package sef.module13.sample;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementSample {

	//	Take note that not all statements are supported by all servers
	//	Some statements, like a few used here, are not STANDARD SQL statements
	public static void main(String[] args) {
		try{
			String username = "sa";
			String password = "";
			DriverManager.registerDriver (new Driver());
            String url = "jdbc:h2:tcp://localhost/~/test";
            Connection cn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successfully established!");
			
			//	This statement lists all tables found in the currently selected
			// 	database, which in this case is the 'dog' database as defined
			//	in the URL set when establishing a connection
			System.out.println("\n***List of Tables in '" + username + "' schema***");
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USER_TABLES");			
			
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			
			System.out.println("\n***List of Columns in 'Account' Table***");
			
			//	This statement lists all columns found in the currently selected
			// 	table, which in this case is the 'dog' table
			rs = st.executeQuery("SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'ACCOUNT'");			
			
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			
			System.out.println("\n***List all entries in the Account Table***");
			
			//	This statement is a STANDARD SQL Statement
			//	This statement lists all dog records from the 'dog' table
			rs = st.executeQuery("SELECT * FROM ACCOUNT");			
			
			while(rs.next()){
				System.out.println(rs.getString(1) + " - " + 
									rs.getString(2) + " - " +
									rs.getString(3) + " - " +
									rs.getString(4));
								
			}
			
			rs.close();
			st.close();
			cn.close();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
