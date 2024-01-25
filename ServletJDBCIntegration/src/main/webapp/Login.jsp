<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href= 
"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    /> 



</head>
<body>



<!-- NAVBAR -->
    <nav class="navbar navbar-expand navbar-dark bg-success"> 
      <div class="container-fluid"> 
        <a class="navbar-brand" href="Register.html"> 
          Register Here
        </a> 
        <ul class="navbar-nav me-auto mb-2 mb-lg-0"> 
          <!-- NAVBAR LINKS -->
          <li class="nav-item"> 
            <a class="nav-link active" href="Login.jsp">Login</a> 
          </li>
          <li class="nav-item"> 
            <a class="nav-link active" href="Retrive.jsp">Search</a> 
          </li> 
          <li class="nav-item"> 
            <a class="nav-link active" href="DeleteUser.jsp">Delete Here</a> 
          </li> 
          <li class="nav-item"> 
            <a class="nav-link active" href="SearchByDate.jsp">Search By DOB</a> 
          </li>
        </ul> 
      </div> 
    </nav> 
    <script src= 
"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    ></script> 

<br></br>

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