package Sample;

//Program to Execute a SELECT Query irrespective of any database..good example for 
//Run Time Polymorphism

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Select_SQL_Execute_Query_Selenium2 {
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		try {
		Driver driverRef = new Driver();
		
//		Step 1 :- Load or register to *mySql* database
		
		DriverManager.registerDriver(driverRef);
		System.out.println("Driver is registered");
		
//		Step 2:- Connect to Database
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", 
																"root", "root");
		System.out.println("Database connected");
//		Step 3 :- Create Query Statement
		Statement stmt = con.createStatement();
		
		String query = "select * from students_info";
		System.out.println("Query is created");
		
//		Step 4 :- Execute Query Statement
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ "\t" + rs.getString(2)+ "\t" 
									+ rs.getString(3)+ "\t" + rs.getString(4));
		}
		System.out.println("Query Executed");
		}
		catch(SQLException e){
			System.err.println("Query Not Executed");
		}
		
//		Close the db Connection
		finally {
		con.close();
		System.out.println("Database Connection closed");
		}
	}

}
