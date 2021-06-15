package com.practise;


import java.sql.SQLException;
import java.util.Scanner;

public class BillingApplication {
	 Scanner sc;
	 BillingDatabase db;
	 
	 public void appSecurity() throws ClassNotFoundException, SQLException 
	 {
		 System.out.println("$$$$$$JAI ABI DEPARTMENTAL STORE$$$$$");
		 sc=new Scanner(System.in);
		 String username,password;
		 System.out.println("LOGIN TO BILLING APPLICATION");
		 System.out.println("Username");
		 username=sc.next();
		 System.out.println("Password");
		 password=sc.next();
		 if(username.toLowerCase().equals(username)&&password.toLowerCase().equals(password))
		 {
			 System.out.println("LOGGING...");
			 
		 }
		 else
		 {
			 System.out.println("INCORRECT USERNAME OR PASSWORD");
		 }
		 employeePermission();
		 
	 }
	 public void employeePermission() throws ClassNotFoundException, SQLException
	 {   db=new BillingDatabase();
		 sc=new Scanner(System.in);
		 System.out.println("EMPLOYER LOGIN TYPE");
		 System.out.println("LOGGER TYPE 1.ADMIN LOGIN");
		 System.out.println("LOGGER TYPE 2.BILLER LOGIN");
		 System.out.println("LOGGER TYPE 3.STOCK KEEPER LOGIN");
		 System.out.println("Enter the Logger Type...");
		 int logtype=sc.nextInt();
		 switch(logtype) {
		 case 1:adminLogin();
		        employeePermission();
		 case 2:billerLogin();
		        employeePermission();
		 case 3:stockKeeperLogin();
		        employeePermission();
		 default:System.out.println("Enter Correct Option");
			     System.exit(0);
		         break;
		 }
		 
	 }
	 public void adminLogin() throws ClassNotFoundException, SQLException
	 {
		 db=new BillingDatabase();
		 db.loginAdmin();
		 
		 
		 
	 }
     public void billerLogin() throws ClassNotFoundException, SQLException 
     {
    	 db=new BillingDatabase();
    	 db.loginBiller();
    	 
    	 
     }
     public void stockKeeperLogin() throws ClassNotFoundException, SQLException
     {
    	 db=new BillingDatabase();
    	 db.loginStockKeeper();
          
     }
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BillingApplication bp=new BillingApplication();
		bp.appSecurity();

	}

}
