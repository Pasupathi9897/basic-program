package com.dxc.Hib_Demo2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dxc.DAO.DAO;
import com.dxc.DAO.EmployeeDAO;
import com.dxc.beans.Employee;


public class EmployeeConsoleUI {

public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
		
		int eid;
		String ename;
		String mobile;
		
		int choice=0;
		
		DAO<Employee> employeeDAO=null;
		Employee employee=null;
			
		while(choice!=6)
		{
			System.out.println("1. save Employee");
			System.out.println("2. updating Existing employee data");
			System.out.println("3. Delete employee");
			System.out.println("4. Display one col data of employee");
			System.out.println("5.Display Employee");
			System.out.println("6. Exit");
			System.out.println();
			System.out.println("Enter your option : ");
			choice=s.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("saving student info into the database");
				
				employeeDAO=new EmployeeDAO();
				System.out.print("enter id :");
				eid=s.nextInt();
				
				System.out.print("enter name :");
				ename=s.next();
				
				System.out.print("enter mobile :");
				mobile=s.next();
				
				employee=new Employee(eid, ename, mobile);
				
				if(employeeDAO.insert(employee))
				{
					System.out.println("successfully entered");
				}
				else
				{
					System.out.println("not entered successfully");
				}
			
				break;
				
			case 2:
				
				System.out.println("update operation");
				
				System.out.print("enter id :");
				eid=s.nextInt();
				
				System.out.print("enter name :");
				ename=s.next();
				
				System.out.print("enter mobile :");
				mobile=s.next();
				
				employee=new Employee(eid, ename, mobile);
				employeeDAO=new EmployeeDAO();
				if(employeeDAO.update(employee))
				{
					System.out.println("Inserted successfully");
				}
				else
				{
					System.out.println("Failed to edit");
				}	
				break;
				
			case 3:
				
				System.out.println("delete operation");
				System.out.print("enter id :");
				eid=s.nextInt();
				employeeDAO=new EmployeeDAO();
				if(employeeDAO.delete(eid))
				{
					System.out.println("deleted");
				}
				else
				{
					System.out.println("not deleted");
				}
				
				
				break;
				
				
			case 4:
				
				System.out.println("Display operation");
				System.out.println("Enter student id to find : ");
				eid = s.nextInt();
				
					employeeDAO=new EmployeeDAO();
					employee = employeeDAO.find(eid);
					
					if(employee != null) 
					{
						System.out.println("Student Found : ");
						System.out.println(employee);
					}
					else 
					{
						System.out.println("Student not found with id : "+eid);
					}			

				break;
			case 5:
				System.out.println("Display All operation");
				employeeDAO=new EmployeeDAO();
				List<Employee> employees=employeeDAO.findAll();
				employees.stream()
						.forEach(System.out::println);
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid");
			}
		}

	}
			


}

