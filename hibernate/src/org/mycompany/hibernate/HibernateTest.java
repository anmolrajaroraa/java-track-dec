package org.mycompany.hibernate;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mycompany.dto.Address;
import org.mycompany.dto.UserDetails;
import org.mycompany.dto.User_Id_And_Name;
import org.mycompany.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UserDetails.getCompanyName();
		
		UserDetails user = new UserDetails();
		
		User_Id_And_Name userIdAndName = new User_Id_And_Name();
		userIdAndName.setUserId(1);
		userIdAndName.setUserName("First User");
		
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
		
		Address prevAddress1 = new Address();
		prevAddress1.setStreet("Old street 1");
		prevAddress1.setCity("Old city 1");
		prevAddress1.setState("Old state 1");
		prevAddress1.setPincode("560056");
		
		Address prevAddress2 = new Address();
		prevAddress2.setStreet("Old street 2");
		prevAddress2.setCity("Old city 2");
		prevAddress2.setState("Old state 2");
		prevAddress2.setPincode("561156");
		
		Vehicle vehicle = new Vehicle();
		//vehicle.setVehicleId(1);
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("SUV");
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleName("Bus");
		
		//user.setUserId(1); //natural key
		//user.setUserName("First user");
		//user.setAddress("First user's address");
		user.setUserIdAndName(userIdAndName);
		user.setDescription("Description goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes hereDescription goes here");
		user.setJoiningDate(new Date());
		user.setDoNotSaveMe("Nothing");
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		user.getListOfPrevAddresses().add(prevAddress1);
		user.getListOfPrevAddresses().add(prevAddress2);
		//user.setVehicle(vehicle);
		//user.getVehicles().add(vehicle);
		//user.getVehicles().add(vehicle2);
		//user.getVehicles().add(vehicle3);
		user.assignVehicle(vehicle);
		user.assignVehicle(vehicle2);
		user.assignVehicle(vehicle3);
		
		//vehicle.setUser(user);
		//vehicle2.setUser(user);
		//vehicle3.setUser(user);
		
		//Set<Address> listOfPrevAddresses = new HashSet<>();
		//listOfPrevAddresses.add(prevAddress1);
		//listOfPrevAddresses.add(prevAddress2);
		//user.setListOfPrevAddresses(listOfPrevAddresses);
		
		//System.out.println(user.toString());
		//System.out.println(UserDetails.getCompanyName());
		
		//Object obj = new Object();
		//obj.toString();
		//Object obj = user;
		
		UserDetails user2 = new UserDetails();
		
		User_Id_And_Name userIdAndName2 = new User_Id_And_Name();
		userIdAndName2.setUserId(2);
		userIdAndName2.setUserName("Second user");
		
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
		
		Address user2PrevAddress1 = new Address();
		user2PrevAddress1.setStreet("Old street 101");
		user2PrevAddress1.setCity("Old city 101");
		user2PrevAddress1.setState("Old state 101");
		user2PrevAddress1.setPincode("101010");
		
		Address user2PrevAddress2 = new Address();
		user2PrevAddress2.setStreet("Old street 102");
		user2PrevAddress2.setCity("Old city 102");
		user2PrevAddress2.setState("Old state 102");
		user2PrevAddress2.setPincode("010101");
		
		Vehicle user2vehicle = new Vehicle();
		//user2vehicle.setVehicleId(2);
		user2vehicle.setVehicleName("2-wheeler");
		
		Vehicle user2vehicle2 = new Vehicle();
		user2vehicle2.setVehicleName("MUV");
		
		Vehicle user2vehicle3 = new Vehicle();
		user2vehicle3.setVehicleName("3-wheeler");
		
		//user2.setUserId(2);
		//user2.setUserName("Second user");
		//user2.setAddress("Second user's address");
		user2.setUserIdAndName(userIdAndName2);
		user2.setDescription("Description again goes here");
		user2.setJoiningDate(new Date());
		user2.setDoNotSaveMe("Nothing again");
		user2.setHomeAddress(homeAddress2);
		user2.setOfficeAddress(officeAddress2);
		user2.getListOfPrevAddresses().add(user2PrevAddress1);
		user2.getListOfPrevAddresses().add(user2PrevAddress2);
		//user2.setVehicle(user2vehicle);
		//user2.getVehicles().add(user2vehicle);
		//user2.getVehicles().add(user2vehicle2);
		//user2.getVehicles().add(user2vehicle3);
		user2.assignVehicle(user2vehicle);
		user2.assignVehicle(user2vehicle2);
		user2.assignVehicle(user2vehicle3);
		
		//user2vehicle.setUser(user2);
		//user2vehicle2.setUser(user2);
		//user2vehicle3.setUser(user2);
		
		user.assignVehicle(user2vehicle);
		user.assignVehicle(user2vehicle2);
		user.assignVehicle(user2vehicle3);
		user2.assignVehicle(vehicle);
		user2.assignVehicle(vehicle2);
		user2.assignVehicle(vehicle3);
		
		//System.out.println(user2.toString());
		//System.out.println(UserDetails.getCompanyName());
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		//session.save(vehicle);
		//session.save(user2vehicle);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		vehicle = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, userIdAndName);
		System.out.println("User object extracted");
//		System.out.println("Vehicle object extracted");
//		System.out.println("Username is " + user.getUserIdAndName().getUserName());
		System.out.println("User object extracted from DB -> " + user.toString());
//		System.out.println("Prev addresses of user -> " + user.getListOfPrevAddresses());
//		session.close();
		System.out.println(user.getListOfPrevAddresses().size());
		System.out.println("Prev addresses of user -> " + Arrays.toString(user.getListOfPrevAddresses().toArray()));
		vehicle = (Vehicle) session.get(Vehicle.class, 1);
		System.out.println("Vehicle object extracted from DB -> " + vehicle.toString());
		System.out.println("UserList is " + Arrays.toString(vehicle.getUserList().toArray()));
	}

}
