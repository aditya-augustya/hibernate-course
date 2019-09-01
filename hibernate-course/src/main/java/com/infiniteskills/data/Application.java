package com.infiniteskills.data;

import java.util.Date;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.infiniteskills.data.entities.User;
import org.hibernate.Transaction;




public class Application {
	
	 static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			// Integer stId = null;
			
			User user = new User();
			user.setBirthDate(getMyBirthday());
			user.setCreatedBy("hagrid");
			user.setCreatedDate(new Date());
			user.setEmailAddress("vim.malasa@hotmail.com");
			user.setFirstName("Vimal");
			user.setLastName("Masala");
			user.setLastUpdatedBy("Radi");
			user.setLastUpdatedDate(new Date());
			
			System.out.println("Dataa : " + user);
			
			session.save(user);
			tx.commit();
			
			session.beginTransaction();
			/*
			 * 
			//update while inserting
		    User dbUser = (User) session.get(User.class, user.getUserId());  
		    dbUser.setFirstName("spoky");
		    
		    */
		    
		    session.update(user);
			session.getTransaction().commit();
			session.refresh(user);
			//tx.commit();
			
			System.out.println("Dataa  2 : " + tx);
			System.out.println(" My Age : " +user.getAge());
			//session.close();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
	
	private static Date getMyBirthday(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1989);
		calendar.set(Calendar.MONTH, 8);
		calendar.set(Calendar.DATE, 18);
		return calendar.getTime();
	}
}
