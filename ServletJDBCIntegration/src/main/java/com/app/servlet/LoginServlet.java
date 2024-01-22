package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String uid=req.getParameter("uid");
		String password=req.getParameter("psw");
//		if(uid.equals("100")&&password.equals("veera"))
//		{
//			out.print("login Success");
//		}
//		else
//		{
//			out.print("login fail try again");
//		}
//		
		
	try {
	
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
		PreparedStatement ptmt=con.prepareStatement("select *from emptabs where eid=? and ename=?");
		
		ptmt.setString(1,uid);
		ptmt.setString(2,password);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next())
		{
			out.print("login Success with id " +rs.getString(1)+" name " + rs.getString(2)+" address "+ rs.getString(4));
			
		}
		else
		{
			out.print("user not exist");
		}
		
	
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//System.out.print(e.printStackTrace());
	}
	}
}




