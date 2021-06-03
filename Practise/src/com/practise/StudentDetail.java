package com.practise;
import java.util.HashMap;
import java.sql.*;
import java.util.Scanner;
import java.util.Set;

public class StudentDetail {
	Scanner sc;
	int option;
	UserData ud;
	DataBase1 db;
	//HashMap<Integer,UserData> data;
	void createStudent() throws ClassNotFoundException, SQLException {
		System.out.println("Enter the Option");
		sc=new Scanner(System.in);
		System.out.println("1.Create student");
		System.out.println("2.View Student");
		System.out.println("3.ViewAll");
		System.out.println("4.delete student details");
		System.out.println("5.Delete all details");
		System.out.println("Enter the option");
		option=sc.nextInt();
		switch (option) {
		case 1: showStudentDetail();
		        createStudent();
		        break;
		case 2: viewStudent();
		        createStudent();
		        break;
		case 3: viewAllStudent();
		        createStudent();
		        break;
		case 4: deleteDetail();
		        createStudent();
		        break;
		case 5:deleteall();
		       createStudent();
		default :System.exit(0);
			     break;
		}
		
	}
	void showStudentDetail() throws ClassNotFoundException, SQLException 
	{
		sc=new Scanner(System.in);
		ud=new UserData();
		System.out.println("Enter the rollno");
	    ud.setRno(sc.nextInt());
	    System.out.println("Enter the name");
	    ud.setName(sc.next());
	    System.out.println("Enter the place");
	    ud.setPlace(sc.next());
	    System.out.println("Enter the age");
	    ud.setAge(sc.nextInt());
	    System.out.println("Enter the sex");
	    ud.setSex(sc.next());
	    System.out.println("Enter the mobile no");
	    ud.setMobNo(sc.next());
	    db=new DataBase1();
		db.insertValues(ud);
		System.out.println("Student Values Inserted Succesfully");
	    }
	/*private void saveData(UserData ud) throws ClassNotFoundException, SQLException 
	{
     if(ud==null) {
    	 // ud=new HashMap<Integer,UserData>();
    	  ud=new UserData();
      }
     // data.put(ud.getRno(),ud);
             
		
		
		
	}*/
    void viewStudent() throws SQLException, ClassNotFoundException 
    {   ud=new UserData(); 
    	db=new DataBase1();
		db.show(ud);
		}
	void viewAllStudent() throws SQLException, ClassNotFoundException 
	{
		db=new DataBase1();
		System.out.println("View All Student");
	    db.showAll(ud);
	 }
	
	void deleteDetail() throws ClassNotFoundException, SQLException
	{
		 db=new DataBase1();
		 db.delete(ud);
		/*sc=new Scanner(System.in);
		System.out.println("Delete detail");
		System.out.println("Enter the rollno to delete");
		int rollno=sc.nextInt();
		if(data.containsKey(rollno)){
			data.remove(rollno);
			System.out.println("Deleted Successfully");
		}
			else {
				System.out.println("No Data Found");
				
				
		}*/
		
		
	}
	void deleteall() throws SQLException, ClassNotFoundException
	   
	{
		db=new DataBase1();
		db.deleteAll(ud);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDetail sd=new StudentDetail();
        sd.createStudent();
	}

}
