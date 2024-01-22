package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchByDobServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String fd=request.getParameter("fromdate");
	    String td=request.getParameter("todate");
	    
	    if(fd.equals("")||td.equals(""))
{
	    	out.print("please enter from date or to date");
	
}
	    
	    
	    System.out.println("from date is"+fd);
	    System.out.println("to date is"+td);
	    
	    
	    SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date udob;
	    
	    try {
	    	
	    	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
			PreparedStatement ptmt=con.prepareStatement("select *from emptabs where dateofbirth between ? and ?");
			udob = sdf.parse(fd);
			
			System.out.println(udob);
		    long ms=udob.getTime();
			java.sql.Date sqfd=new java.sql.Date(ms);
			System.out.println("from date "+sqfd);
			
			udob = sdf.parse(td);
			
			System.out.println(udob);
		    long ms1=udob.getTime();
			java.sql.Date sqtd=new java.sql.Date(ms1);
			System.out.println("to date"+sqtd);
			
			
			ptmt.setDate(1,sqfd);
			ptmt.setDate(2,sqtd);
			ResultSet rs=ptmt.executeQuery();
			
			out.print("<html<body><center><h1>User Dtails</h1><table border='1'><tr> <td>USER_ID</td> <td>USER_NAME</td> <td>GENDER</td><td>ADDRESS</td><td>EMAIL</td><td>MOBILE</td><td>DOB</td></tr>");
			while(rs.next())
			{
				//out.print("login Success with id " +rs.getString(1)+" name " + rs.getString(2)+" address "+ rs.getString(4));
				
			
			
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getDate(7)+"</td></tr>");	
					
			}
			out.println("</table></center></body></html>");
			
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.print(e.printStackTrace());
		}
	   
	}
}