</center><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "oracle.jdbc.driver.OracleDriver";%>
<%!String url = "jdbc:oracle:thin:@localhost:1521:XE";%>
<%!String user = "system";%>
<%!String psw = "tiger";%>
<%
String Id = request.getParameter("id");
//int eId=Integer.parseInt(Id);
String ename=request.getParameter("uname");
String egen=request.getParameter("gender");
String address=request.getParameter("address");
String email=request.getParameter("email");
String mobile=request.getParameter("mobile");

if(Id != null)
{
Connection con = null;
PreparedStatement ps = null;
int personID = Integer.parseInt(Id);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update emptabs set eid=?,ename=?,egen=?,eaddr=?,email=?,mobile=? where eid="+personID;
ps = con.prepareStatement(sql);
ps.setInt(1,personID);
ps.setString(2, ename);
ps.setString(3, egen);
ps.setString(4, address);
ps.setString(5, email);
ps.setString(6, mobile);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>