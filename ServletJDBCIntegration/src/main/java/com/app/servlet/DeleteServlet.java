package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet  extends HttpServlet{
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    String uId = request.getParameter("uid");
	    
	    if(uId.equals(""))
	    {
	    	out.print("enter uid to delete");
	    }
	    int eId=Integer.parseInt(uId);
	    System.out.println("uid is"+uId);

	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	        String user = "system";
	        String pass = "tiger";
	        String query = "delete from emptabs where eid=?";
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", user, pass);
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, eId);

	        int i = ps.executeUpdate();

	        if(i > 0) {
	            out.println("User successfully removed...");
	        }
	        
	        
	        else
	        {
	        	out.println("User not removed...not exist");
	        	
	        }

	    } catch (Exception e) {
	    	
	        System.out.println(e);
	    }
	}

}
