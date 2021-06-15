package com.practise;

import java.util.Scanner;
import java.sql.*;

public class BillingDatabase {
	Scanner sc;
	String url="jdbc:mysql://localhost:3306/billingapplication";
	String username="root";
	String password="admin";
	Connection con;
	Statement st;
	StockKeeper sk;
	BillingDatabase() throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}
	 void createAdmin() throws SQLException 
	{
		sc=new Scanner(System.in);
		System.out.println("Create username");
		String usernameAdmin=sc.next();
		System.out.println("Create password");
		String passwordAdmin=sc.next();
		System.out.println("Enter Employe id");
		int empid=sc.nextInt();
		con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement("insert into adminup(username,password,emp_id) values(?,?,?)");
		st.setString(1,usernameAdmin);
		st.setString(2,passwordAdmin);
		st.setInt(3,empid);
		st.executeUpdate();
		System.out.println("Username and password is set for admin successfully");
	}
		
	void loginAdmin() throws SQLException, ClassNotFoundException
	{
		sc=new Scanner(System.in);
		System.out.println("Username");
		String uname=sc.next();
		System.out.println("Password");
		String pass=sc.next();
		con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from adminup");
		rs.next();
	    if(uname.toLowerCase().equals(rs.getObject(1))&&pass.toLowerCase().equals(rs.getObject(2)))
	    {
	    	System.out.println("Admin Login Suceessfull");
	    	
		}
	    else
	    {
	    	System.out.println("Admin username or password is incorrect");
	    }
		sc=new Scanner(System.in);
		System.out.println("Option 1.Create Username and Password for Admin");
		System.out.println("Option 2.Login Admin");
		System.out.println("Option 3.Create Username and Password for Biller");
		System.out.println("Option 4.Login Biller");
		System.out.println("Option 5.Create Username and Password for StockKeeper");
		System.out.println("Option 6.Login Stock Keeper ");
		System.out.println("Option 7:Enter employedetails");
		System.out.println("Option 8:Update the password of biller");
		System.out.println("Enter option");
		int option=sc.nextInt();
		switch(option) {
		case 1:createAdmin();
		       break;
		case 2:loginAdmin();
		       break;
		case 3:createBiller();
		       loginAdmin();
		       break;
		case 4:loginBiller();
		       loginAdmin();
		case 5:createStockKeeper();
		       loginAdmin();
		case 6:loginStockKeeper();
		       loginAdmin();
		case 7:employedetail();
		       loginAdmin();
		case 8:updateBillerup();
		       loginAdmin();
		case 9:updateStockKeeper();
		       loginAdmin();
		case 10:updateAdminup();
		        loginAdmin();
		       default:System.out.println("Enter the correct option");
		        System.exit(0);
		        break;
		       
		}
	    }
	
	public void updateAdminup() throws SQLException
	 {
		  sc=new Scanner(System.in);
		  System.out.println("Update the Password");
		  String pass=sc.next();
		  System.out.println("Enter the Employe id");
		  int empid=sc.nextInt();
		  con=DriverManager.getConnection(url, username, password);
		  PreparedStatement st=con.prepareStatement("update adminup set password=? where emp_id=?");
		  st.setString(1, pass);
		  st.setInt(2,empid);
		  st.executeUpdate();
		  System.out.println("updated AdminPassword");
	}
	  public void createBiller() throws SQLException
	  {
		  sc=new Scanner(System.in);
		  System.out.println("Create Username and Password for Biller");
		  System.out.println("Create Username");
		  String usernameBiller=sc.next();
		  System.out.println("Create Password");
		  String passwordBiller=sc.next();
		  System.out.println("Enter the employe id");
		  int empid=sc.nextInt();
		  con=DriverManager.getConnection(url, username, password);
		  PreparedStatement st=con.prepareStatement("insert into billerup(username,password,emp_id) values (?,?,?)");
		  st.setString(1, usernameBiller);
		  st.setString(2,passwordBiller);
		  st.setInt(3, empid);
		  st.executeUpdate();
		  System.out.println("Username and password is Created Successfully");
      }
	  public void loginBiller() throws SQLException, ClassNotFoundException 
	  {
		  sc=new Scanner(System.in);
		  System.out.println("Login Biller");
		  System.out.println("Username");
		  String uname=sc.next();
		  System.out.println("Password");
		  String pass=sc.next();
		  con=DriverManager.getConnection(url, username, password);
		  st=con.createStatement();
		  ResultSet rs=st.executeQuery("select * from billerup");
		  rs.next();
		  if(uname.toLowerCase().equals(rs.getObject(1))&&pass.toLowerCase().equals(rs.getObject(2)))
		  {
			  System.out.println("Biller Logging");
		  }
		  else
		  {
			  System.out.println("Biller Username and Password is Incorrect");
		  }
		  sk=new StockKeeper();
	  }
	  public void updateBillerup() throws SQLException
	  {
		  sc=new Scanner(System.in);
		  System.out.println("Update the Password");
		  String pass=sc.next();
		  System.out.println("Enter the Employe id");
		  int empid=sc.nextInt();
		  con=DriverManager.getConnection(url, username, password);
		  PreparedStatement st=con.prepareStatement("update billerup set password=? where emp_id=?");
		  st.setString(1, pass);
		  st.setInt(2,empid);
		  st.executeUpdate();
		  System.out.println("updated");
	 }
   public void createStockKeeper() throws SQLException 
   {
	   sc=new Scanner(System.in);
	   System.out.println("STOCK KEPPER");
	   System.out.println("Create the Username");
	   String uname=sc.next();
	   System.out.println("Create the Password");
	   String pass=sc.next();
	   System.out.println("Enter the Employe id");
	   int empid=sc.nextInt();
	   con=DriverManager.getConnection(url, username, password);
	   PreparedStatement st=con.prepareStatement("insert into stockkeeperup(username,password,emp_id) values(?,?,?)");
	   st.setString(1,uname);
	   st.setString(2,pass);
	   st.setInt(3, empid);
	   st.executeUpdate();
	   System.out.println("Username and Password for Stock Keeper is Created Successfully");
    }
   public void updateStockKeeper() throws SQLException
   {
	   sc=new Scanner(System.in);
		  System.out.println("Update the Password");
		  String pass=sc.next();
		  System.out.println("Enter the Employe id");
		  int empid=sc.nextInt();
		  con=DriverManager.getConnection(url, username, password);
		  PreparedStatement st=con.prepareStatement("update stockkeeperup set password=? where emp_id=?");
		  st.setString(1, pass);
		  st.setInt(2,empid);
		  st.executeUpdate();
		  System.out.println("Stock Keeper password updated");
	 }
   public void loginStockKeeper() throws SQLException, ClassNotFoundException
   {
	   sc=new Scanner(System.in);
	   System.out.println("Username");
	   String uname=sc.next();
	   System.out.println("Password");
	   String pass=sc.next();
	   con=DriverManager.getConnection(url, username,password);
	   st=con.createStatement();
	   ResultSet rs=st.executeQuery("select * from stockkeeperup");
	   rs.next();
	   if(uname.equals(rs.getObject(1))&&pass.equals(rs.getObject(2)))
	   {
		   System.out.println("Stock Keeper Logging..");
		   
	   }
	   else
	   {
		   System.out.println("Stock Keeper Username or Password is InCorrect");
		   loginStockKeeper();
	   }
	   sk=new StockKeeper();
	   sk.stockItems();
	  }
     public void employedetail() throws SQLException
     {
    	 sc=new Scanner(System.in);
    	 System.out.println("Enter the Employe name");
    	 String empName=sc.next();
    	 System.out.println("Enter the Employe Address");
    	 String empAddress=sc.next();
    	 System.out.println("Enter the employee age");
    	 int empAge=sc.nextInt();
    	 System.out.println("Enter the role");
    	 String emprole=sc.next();
    	 System.out.println("Enter the Phone No");
    	 String empPhoneNo=sc.next();
    	 con=DriverManager.getConnection(url,username,password);
    	 String query="INSERT INTO EMPLOYEDETAILS(EMP_NAME,EMP_ADDRESS,EMP_AGE,EMP_ROLE,EMP_PHONE)VALUES(?,?,?,?,?)";
    	 PreparedStatement st=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
    	 st.setString(1, empName);
    	 st.setString(2, empAddress);
    	 st.setInt(3, empAge);
    	 st.setString(4, emprole);
    	 st.setString(5, empPhoneNo);
    	 st.addBatch();
    	 System.out.println("Values are inserted Successfully");
    	 st.executeBatch();
    	ResultSet rs=st.getGeneratedKeys();
    	while(rs.next())
    	{
    		 System.out.println("UJA"+rs.getString(1));
    	}
    	
    	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
