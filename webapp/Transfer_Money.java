package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Date;
import java.util.Scanner;

public class Transfer_Money {
	Connection myConn = null;
	
	PreparedStatement myStmt = null;

	
	
	String dbUrl = "jdbc:mysql://localhost:3306/bank";
	String user = "sukumar";		
	String pass = "Naveen123";
	 int accbalance;
	 Account_Balance Acc_Det=new Account_Balance();
   public void Transfer(int amount,String narration) throws SQLException
   {
	   try {
	accbalance=Acc_Det.get_Account_balance(); 
	   }
	   catch (SQLException e) {
			
			e.printStackTrace();
		}
	   
	try {
		// 1. Get a connection to database
		myConn = DriverManager.getConnection(dbUrl, user, pass);
		System.out.println(accbalance);
		
		
		accbalance=accbalance-amount;
		myStmt = myConn.prepareStatement("insert into transaction_details values(CURDATE(),?,?,?)");
		myStmt.setString(1, narration);
		myStmt.setInt(2, amount);
		myStmt.setInt(3, accbalance);
		myStmt.executeUpdate();
	    Acc_Det.set_Account_balance(accbalance);		
		
	}
	catch (Exception exc) {
		exc.printStackTrace();
	}
	finally {
		
		
		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
		
		
	}
}
}
