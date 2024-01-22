<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
System.out.print("id is"+id);
int Id=Integer.parseInt(id);
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
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from emptabs where eid="+Id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>Update data from database in jsp</h1>
<form method="post" action="update-process.jsp">
<input type="hidden" name="id" value="<%=resultSet.getInt("eid") %>">
User Id  :<input type="text" name="id" value="<%=resultSet.getInt("eid") %>">

User Name: <input type="text" name="uname" value="<%=resultSet.getString("ename") %>">
<br>

Gender   : <input type="text" name="gender" value="<%=resultSet.getString("egen") %>">

Address  : <input type="text" name="address" value="<%=resultSet.getString("eaddr") %>">
<br>

Email Id : <input type="email" name="email" value="<%=resultSet.getString("email") %>">

mobile   :   <input type="text" name="mobile" value="<%=resultSet.getString("mobile") %>">

<br>

Dateofbirth   :   <input type="text" name="mobile" value="<%=resultSet.getDate("dateofbirth") %>">

<br><br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</center>
</body>
</html>