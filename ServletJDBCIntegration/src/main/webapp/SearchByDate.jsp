<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Users Here</title>
</head>
<body>
<form action="searchbydob" method="post">
<center>

<h1>Search Users By DateOfBirth</h1>

Enter From Date:<input type="text" name="fromdate" placeholder="dd-mm-yyyy"><br> 
Enter To Date  : <input type="text" name="todate" placeholder="dd-mm-yyyy"><br> 

<input type="submit"value="search"> <input type="reset" name="cancel" value="clear">


</center>
</form>
</body>
</html>