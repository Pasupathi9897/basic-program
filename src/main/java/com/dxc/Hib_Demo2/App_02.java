package com.dxc.Hib_Demo2;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.dxc.beans.Student;

public class App_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
												.applySettings(configuration.getProperties())
												.buildServiceRegistry();
		
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
//		Student s= (Student) session.get(Student.class,2);
//		System.out.println(s);
//		
//		Query query = session.createQuery("from Student");
//		List<Student> student=query.list();
//		student.forEach(System.out::println);
		
		Student s1=new Student(1, "pasupathi", "pasupathi@gmail.com", "9003299897");
		
		session.beginTransaction();
		session.update(s1);
		session.getTransaction().commit();
		
		
		session.close();
		}

}
