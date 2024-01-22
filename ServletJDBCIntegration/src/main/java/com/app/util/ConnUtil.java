package com.app.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnUtil {
private static Connection con=null;
static {
try {
//Class.forName("oracle.jdbc.driver.OracleDriver");
//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
Class.forName("oracle.jdbc.driver.OracleDriver");  

//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");  

 }
catch (Exception e) {
e.printStackTrace();
}
}
//return conn object
public static Connection getConn(){
return con;
}
}
