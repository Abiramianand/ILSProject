package com.practise;

public class UserData {
	private int rollno;
	private String name;
	private String place;
	private int age;
	private String sex;
	private String MobileNo;
	
	public int getRno() {
		return rollno;
	}
	public void setRno(int  rollno) {
		this.rollno=rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place=place;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
    public String getMobNo() {
    	return MobileNo;
    }
	public void setMobNo(String MobileNo) {
		this.MobileNo=MobileNo;
	}
	public String toString() {
		return "rollno" +getRno()+ "namen =" +getName()+  "place =" +getPlace()+ "age =" +getAge()+ "sex =" +getSex()+ "Mobile no ="
				+ "" +getMobNo() ;
	}

	public static void main(String[] args) {
		

	}

}
