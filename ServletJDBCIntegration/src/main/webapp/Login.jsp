<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<center>
<h1>Welcome To Login Page</h1>

<form action="login" method="post">

User Id  :  <input type="text" name="uid"><br></br>
Password:<input type="password" name="psw" placeholder="empname"><br></br>

<input type="submit" name="login" value="Login ">
<input type="reset" name="cancel" value="cancel"><br><br>

New User :<a href="Register.html">Register Here</a><br/>
Delete User :<a href="DeleteUser.jsp">Delete Here</a></br>
Search User :<a href="Retrive.jsp">Search Users</a></br>
Search Users By DOB :<a href="SearchByDate.jsp">Search Users By DOB</a>
</form>
</center>

</body>
</html>