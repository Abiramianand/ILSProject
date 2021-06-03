package com.practise;
import java.sql.*;
import java.util.Scanner;

public class DataBase1 {
	private String url="jdbc:mysql://localhost:3306/studentdetails";
	private String username="root";
	private String password="admin";
	Connection con;
	Statement st;
	String query;
	Scanner sc;
	ResultSet rs;
	DataBase1() throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}
    public void insertValues(UserData data) throws SQLException 
    {
    	String query="insert into studetail values("+data.getRno()+",'"+data.getName()+"','"+data.getPlace()+"',"+data.getAge()+",'"+data.getSex()+"','"+data.getMobNo()+"');";
    	con=DriverManager.getConnection(url,username,password);
    	st=con.createStatement();
    	st.execute(query);
    	System.out.println("\n"+query); 
    	
   }
      public void showAll(UserData data) throws SQLException
      {   
    	  con=DriverManager.getConnection(url, username, password);
    	  st=con.createStatement();
    	  rs=st.executeQuery("select * from studetail");
    	  while(rs.next()) {
    	  System.out.print(rs.getInt(1)+" ");
    	  System.out.print(rs.getString(2)+" ");
    	  System.out.print(rs.getString(3)+" ");
    	  System.out.print(rs.getInt(4)+" ");
    	  System.out.print(rs.getString(5)+" ");
    	  System.out.println(rs.getString(6)+" ");
    	  }
      }
      public void show(UserData data) throws SQLException
      {
    	  int rollno;
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println("Enter the rollno");
    	  rollno=sc.nextInt();
    	  con=DriverManager.getConnection(url, username, password);
    	  PreparedStatement st=con.prepareStatement("SELECT * FROM STUDETAIL WHERE ROLLNO=?");
    	  st.setInt(1, rollno);
    	  rs=st.executeQuery();
    	  while(rs.next())
    	  {
    		  System.out.println(rs.getInt(1)+" ");
    		  System.out.println(rs.getString(2)+" ");
    		  System.out.println(rs.getString(3)+" ");
    		  System.out.println(rs.getInt(4)+" ");
    		  System.out.println(rs.getString(5)+" ");
    		  System.out.println(rs.getString(6)+" ");
    		  
    	  }
    	  
      }
      public void delete(UserData ud) throws SQLException
      {
    	  int rollno; 
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println("Enter the rollno");
    	  rollno=sc.nextInt();
    	  con=DriverManager.getConnection(url, username, password);
    	  PreparedStatement st=con.prepareStatement("delete from studetail where rollno=?");
    	  st.setInt(1,rollno);
    	  int count=st.executeUpdate();
    	  System.out.println(count+"row was deleted");
     }
      public void deleteAll(UserData ud) throws SQLException
      {
    	  con=DriverManager.getConnection(url, username, password);
    	 PreparedStatement st=con.prepareStatement("TRUNCATE TABLE STUDETAIL ");
    	 st.executeUpdate();
    	  System.out.println("All student details are deleted successfully");
    	  
    	  
      }
	public static void main(String[] args) throws ClassNotFoundException {
		DataBase1 db=new DataBase1();

	}

}
