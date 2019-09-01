package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.TimeTest;

public class ApplicationTime {

	public static void main(String[] args) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			
			TimeTest test = new TimeTest(new Date());
			session.save(test);
			session.getTransaction().commit();
			
			
			session.refresh(test);
			System.out.println(test.toString());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

}
