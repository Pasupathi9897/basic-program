package com.dxc.DAO;

import com.dxc.beans.Employee;

import junit.framework.TestCase;

public class EmployeeDAOTest extends TestCase {

	public void testInsert() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		assertTrue(employeeDAO.insert(new Employee(101, "employee", "112233")));
	}

}
