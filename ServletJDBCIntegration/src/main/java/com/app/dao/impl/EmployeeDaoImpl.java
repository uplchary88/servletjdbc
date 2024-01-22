package com.app.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.util.ConnUtil;

public class EmployeeDaoImpl implements IEmployeeDao{

	@Override
	public int insertEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		String sql="insert into emptabs values(?,?,?,?,?,?,?)";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		int count=0;
		try
		{
			
			 con=ConnUtil.getConn();
			//create statement
			pstmt=con.prepareStatement(sql);
			//set data to stmt
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpGen());
			pstmt.setString(4, emp.getEmpAddr());
			pstmt.setString(5, emp.getEmail());
			pstmt.setString(6, emp.getMobile());
			pstmt.setDate(7, (Date) emp.getDob());
			//execute stmt
			count=pstmt.executeUpdate();
			} catch (Exception e) {
			e.printStackTrace();
			}
	finally {
		//release connection
		con=null;
			}
		
			return count;
			}
	}
	
	
	
	
