package com.dxc.Hib_Demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dxc.beans.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration=new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
			
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student s= new Student();

		s.setName("pasupathi");
		s.setEmail("pasupathi@gmail.com");
		s.setMobile("9003299897");
		
		session.save(s);
		transaction.commit();
		System.out.println("successfully save in DB");
		
		session.close();
		sessionFactory.close();
		
    }
}
