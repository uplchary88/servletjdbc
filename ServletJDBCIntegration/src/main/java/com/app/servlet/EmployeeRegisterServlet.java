package com.app.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.IEmployeeDao;
import com.app.factory.EmpDaoFactory;
import com.app.model.Employee;

public class EmployeeRegisterServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException 
	{
	resp.setContentType("text/html");
	//1. read input form data
	String eid=req.getParameter("eid");
	String empName=req.getParameter("ename");
	String empGen=req.getParameter("egen");
	String empAddr=req.getParameter("eaddr");
	String empmail=req.getParameter("email");
	String mobile=req.getParameter("mobile");
	String dob=req.getParameter("dateofbirth");
	
	//2. parse data if required
	int empId=Integer.parseInt(eid);
	System.out.println("eid is :"+eid);
	System.out.println("empid is :"+empId);
	System.out.println("empname is :"+empName);
	System.out.println("empgen is :"+empGen);
	System.out.println("empaddr is :"+empAddr);
	System.out.println("empmail is :"+empmail);
	System.out.println("mobile is :"+mobile);
	
	//String dob=emp.getDob();
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	java.util.Date udob;
	try {
		udob = sdf.parse(dob);
	
	System.out.println(udob);
    long ms=udob.getTime();
	java.sql.Date sqdob=new java.sql.Date(ms);
	System.out.println(sqdob);
	
	System.out.println("dob is :"+dob);
	
	//3. create model class object
	Employee emp=new Employee();
	//4. store data in model class obj
	emp.setEmpId(empId);
	emp.setEmpName(empName);
	emp.setEmpGen(empGen);
	emp.setEmpAddr(empAddr);
	emp.setEmail(empmail);
	emp.setMobile(mobile);
	emp.setDob(sqdob);
	//5. create Dao Object using Factory
	IEmployeeDao dao=EmpDaoFactory.getDao();
	//6.call insert operation
	int count=dao.insertEmp(emp);
	//7. print final message
	PrintWriter out=resp.getWriter();
	if(count==1) {
	out.println("Successfully created record with Id : "+empId);
	
	}else {
	out.print("Check manully ... giving problem");
	}
	//8. 
	RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
	rd.include(req, resp);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}