package com.app.factory;
import com.app.dao.IEmployeeDao;
import com.app.dao.impl.EmployeeDaoImpl;
//factory class
public class EmpDaoFactory {
//return POJO object in POJI casted

public static IEmployeeDao getDao() {
return new EmployeeDaoImpl();
}
}