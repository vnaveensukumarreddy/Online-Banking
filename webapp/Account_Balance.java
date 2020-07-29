package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account_Balance {

	
	private String Name="Vennapusa Naveen Sukumar Reddy";
	private long Account_Number=1234567896;
	private int Account_Balance=5500;
	
	public void set_Account_balance(int balance)
	{
		Account_Balance = balance;
		
	}
	public String getName() {
		return Name;
	}
	
	public long getAccount_Number() {
		return Account_Number;
	}
	
	public int get_Account_balance() throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/bank";
		String user = "sukumar";		
		String pass = "Naveen123";

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select Balance from transaction_details");
			  while (myRs.next()) {
			Account_Balance=myRs.getInt("Balance");		
				}
			 
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
			
		}
	  return Account_Balance;
	}
	void Display_Account_Details()
	{
		System.out.println("Name Of the Account Holder"+"  "+getName());
		System.out.println("Account_Number"+"              "+getAccount_Number());
		try {
		System.out.println("Account Balance"+"             "+get_Account_balance());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
