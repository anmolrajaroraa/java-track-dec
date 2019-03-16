package org.mycompany.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mycompany.dto.Address;
import org.mycompany.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UserDetails.getCompanyName();
		
		UserDetails user = new UserDetails();
		
		Address homeAddress = new Address();
		homeAddress.setStreet("Street 1");
		homeAddress.setCity("City 1");
		homeAddress.setState("State 1");
		homeAddress.setPincode("110011");
		
		Address officeAddress = new Address();
		officeAddress.setStreet("Street 101");
		officeAddress.setCity("City 101");
		officeAddress.setState("State 101");
		officeAddress.setPincode("111111");
		
		//user.setUserId(1); //natural key
		//user.setUserName("First user");
		//user.setAddress("First user's address");
		user.setDescription("Description goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes here");
		user.setJoiningDate(new Date());
		user.setDoNotSaveMe("Nothing");
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		
		System.out.println(user.toString());
		System.out.println(UserDetails.getCompanyName());
		
		//Object obj = new Object();
		//obj.toString();
		//Object obj = user;
		
		UserDetails user2 = new UserDetails();
		
		Address homeAddress2 = new Address();
		homeAddress2.setStreet("Street 2");
		homeAddress2.setCity("City 2");
		homeAddress2.setState("State 2");
		homeAddress2.setPincode("220022");
		
		Address officeAddress2 = new Address();
		officeAddress2.setStreet("Street 102");
		officeAddress2.setCity("City 102");
		officeAddress2.setState("State 102");
		officeAddress2.setPincode("111000");
		
		//user2.setUserId(2);
		//user2.setUserName("Second user");
		//user2.setAddress("Second user's address");
		user2.setDescription("Description again goes here");
		user2.setJoiningDate(new Date());
		user2.setDoNotSaveMe("Nothing again");
		user2.setHomeAddress(homeAddress2);
		user2.setOfficeAddress(officeAddress2);
		
		System.out.println(user2.toString());
		System.out.println(UserDetails.getCompanyName());
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User object extracted from DB -> " + user.toString());
	}

}
