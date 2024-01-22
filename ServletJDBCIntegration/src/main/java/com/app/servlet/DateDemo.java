package com.app.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("enter id");
int id=sc.nextInt();
System.out.println("enter name");	
String name=sc.next();
	System.out.println("enter DOB 06-JAN-89 dd-mm-yyyy");	
		String dob=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		try {
		java.util.Date udob=sdf.parse(dob);
			System.out.println(udob);
		long ms=udob.getTime();
			java.sql.Date sqdob=new java.sql.Date(ms);
			System.out.println(sqdob);
			
			//db connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
			PreparedStatement pst=con.prepareStatement("insert into userrecords values(?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDate(3, sqdob);
			
			int result=pst.executeUpdate();
			if(result>0)
			{
				System.out.println("record inserted");
			}
			else
			{
				System.out.println("try again");
				con.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
