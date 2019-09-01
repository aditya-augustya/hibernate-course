package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.Bank;
import com.infiniteskills.data.entities.User;

public class ApplicationBank {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			
			// Transaction transaction = session.beginTransaction();
			Bank bank = new Bank();
			bank.setName("Tyrion Lanister");
			bank.setAddressLine1("Navi mumbai");
			bank.setAddressLine2("Khargar");
			bank.setCity("Mumbai");
			bank.setState("MH");
			bank.setZipCode("3542");
			bank.setCreatedBy("Pinto");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Tyrion");
			bank.setLastUpdatedDate(new Date());
			bank.setInternational(false);
			
			/*
			bank.getContacts().add("Joe");
			bank.getContacts().add("Mary");
			*/
			
			bank.getContacts().put("MANAGER", "Tasha");
			bank.getContacts().put("TELLER", "Sabu");
			
			session.save(bank);
			tx.commit();
			
		}
		catch(Exception e	)
		{
			e.printStackTrace();
		}
		
	}
	
}
