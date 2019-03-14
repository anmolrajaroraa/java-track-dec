package org.mycompany.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mycompany.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UserDetails.getCompanyName();
		UserDetails user = new UserDetails();
		//user.setUserId(1); //natural key
		user.setUserName("First user");
		//user.setAddress("First user's address");
		user.setDescription("Description goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes here");
		user.setJoiningDate(new Date());
		user.setDoNotSaveMe("Nothing");
		
		System.out.println(user.toString());
		System.out.println(UserDetails.getCompanyName());
		
		//Object obj = new Object();
		//obj.toString();
		//Object obj = user;
		
		UserDetails user2 = new UserDetails();
		//user2.setUserId(2);
		user2.setUserName("Second user");
		//user2.setAddress("Second user's address");
		user2.setDescription("Description again goes here");
		user2.setJoiningDate(new Date());
		user2.setDoNotSaveMe("Nothing again");
		
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
