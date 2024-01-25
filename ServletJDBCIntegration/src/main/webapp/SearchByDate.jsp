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