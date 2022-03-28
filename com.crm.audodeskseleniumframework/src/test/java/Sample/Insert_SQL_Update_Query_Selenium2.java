package Sample;

//Program to Execute a UPDATE Query(INSERT, DELETE or UPDATE) irrespective of any database.
//.good example for Run Time Polymorphism

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Insert_SQL_Update_Query_Selenium2 {
	
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
		
		String query = "insert into students_info values ('8','Bharath1','Kumar', 'N')";
		System.out.println("Query is created");
		
//		Step 4 :- Execute Query Statement
		
		int result = stmt.executeUpdate(query);
		
		if (result==1) {
			System.out.println("Query inserted and successful");
		}else {
			System.out.println("Query not inserted and Unsuccessful");
		}
		}catch(SQLException e) {
			System.err.println("Query not Updated");
		}
		
//		Close the db Connection
		finally {
		con.close();
		
		System.out.println("==========Done=======");
		}
	}

}
