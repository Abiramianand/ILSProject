package com.practise;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;



public class StockKeeper {
	Scanner sc;
	String url="jdbc:mysql://localhost:3306/billingapplication";
	String username="root";
	String password="admin";
	Connection con;
	Statement st;
	StockKeeper() throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}
	public void stockItems() throws SQLException 
	{
		sc=new Scanner(System.in);
	    System.out.println("Enter the product No");
		int  productNo=sc.nextInt();
		System.out.println("Enter the Product Name");
		String productName=sc.next();
		System.out.println("Enter the Buying Price");
		int buyingPrice=sc.nextInt();
		System.out.println("Enter the Selling Price");
		int sellingPrice=sc.nextInt();
		System.out.println("Enter the Product Type");
	    String productType=sc.next();
	    Date query=Date.valueOf(LocalDate.now());
	    System.out.println("Enter the quantity");
		int quantity=sc.nextInt();
		
		con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement("insert into stockkeep(product_no,product_name,buying_price,selling_price,product_type,product_buying_on,quantity)values(?,?,?,?,?,?,?)");
		st.setInt(1,productNo);
		st.setString(2, productName);
		st.setInt(3,buyingPrice);
		st.setInt(4,sellingPrice);
		st.setString(5,productType);
		st.setDate(6, query);
		st.setInt(7,quantity);
		st.executeUpdate();
     }
	public void billGenerate() throws SQLException {
		sc=new Scanner(System.in);
    	System.out.println("Enter the Product No");
		int productNo=sc.nextInt();
		System.out.println("Enter the quantity");
		int quantity=sc.nextInt();
		con=DriverManager.getConnection(url, username, password);
		String query="insert into bills(product_no,quantity)values(?,?)";
		PreparedStatement st=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		st.setInt(1,productNo);
		st.setInt(2,quantity);
		st.addBatch();
		st.executeBatch();
		ResultSet rs=st.getGeneratedKeys();
		while(rs.next()) {
			rs.getString(1);
		}
		billing();
	}
	public void billing() throws SQLException
	{
		con=DriverManager.getConnection(url, username, password);
		st=con.createStatement();
		ResultSet rs=st.executeQuery("select bills.product_no,stockkeep.product_name,stockkeep.selling_price,bills.quantity from stockkeep inner join bills on stockkeep.product_no=bills.product_no");
		while(rs.next())
		{
			int product_no=rs.getInt(1);
			String product_name=rs.getString(2);
			int selling_price=rs.getInt(3);
			int quantity=rs.getInt(4);
			System.out.println(product_no+" "+product_name+" "+selling_price+" "+quantity);
			
		}
		
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StockKeeper sk=new StockKeeper();
		sk.billGenerate();

	}

}
