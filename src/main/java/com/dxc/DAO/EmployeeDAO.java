package com.dxc.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.beans.Employee;

public class EmployeeDAO implements DAO<Employee> {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
		
	public void opensession()
	{
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();

		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		session=sessionFactory.openSession();
		session.beginTransaction();
	}
	
	public void closesession()
	{
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	public boolean update(Employee e) {
		// have to pass employee object
		opensession();
		session.update(e);		
		closesession();
		return true;
	}

	public boolean insert(Employee e) {
		
		opensession();
		session.save(e);
		closesession();

		return true;
	}

	public boolean delete(int id) {
		opensession();
		Employee employee=(Employee)session.get(Employee.class, id);
		session.delete(employee);
		closesession();

		return true;
	}

	public Employee find(int id) {
		opensession();
		Employee e= (Employee) session.get(Employee.class,id);
		closesession();
		return e;
	}

	public List<Employee> findAll(){
		opensession();
		Query query = session.createQuery("from Employee");
		List<Employee> e=query.list();
		closesession();
		return e;
	}

	}
