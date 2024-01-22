<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

String driver ="oracle.jdbc.driver.OracleDriver";
String connectionUrl = "jdbc:oracle:thin:@localhost:1521:xe";

String userid = "system";
String password = "tiger";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
<center>
<h1><U>Retrieve data from database in jsp</U></h1>
<table border="1">
<tr>
<td>USER_ID</td>
<td>USER_NAME</td>
<td>GENDER</td>
<td>ADDRESS</td>
<td>EMAIL</td>
<td>MOBILE</td>
<td>DOB</td>
<td>ACTION</td>
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from emptabs";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("eid")%></td>
<td><%=resultSet.getString("ename") %></td>
<td><%=resultSet.getString("egen") %></td>
<td><%=resultSet.getString("eaddr") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("mobile") %></td>
<td><%=resultSet.getDate("dateofbirth") %></td>
<td><a href="Update.jsp?id=<%=resultSet.getInt("eid")%>">Edit Here</a><br/></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
</center>
</body>
</html>