package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.User;


public class ApplicationUser {

	
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			
			User user = new User();
			Address address = new Address();
			Address address2 = new Address();
			setAddressData(address);
			setAddressData2(address2);
			user.getAddress().add(address);
			user.getAddress().add(address2);
			
			setUserData(user);
			
			session.save(user);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private static void  setAddressData(Address address){
		
		address.setAddressLine1("line 3");
		address.setAddressLine2("line 4");
		address.setCity("Boston");
		address.setState("LO");
		address.setZipCode("234");
	}
	
	private static void  setAddressData2(Address address){
		
		address.setAddressLine1("line 1");
		address.setAddressLine2("line 2");
		address.setCity("new jersy");
		address.setState("PA");
		address.setZipCode("533");
	}
	
	private static void  setUserData(User user){
		
		user.setAge(22);
		user.setBirthDate(new Date());
		user.setCreatedBy("Marwin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("mar2");
		user.setFirstName("maewin");
		user.setLastName("bowexer");
		user.setLastUpdatedBy("mrl");
		user.setLastUpdatedDate(new Date());
	}

}
