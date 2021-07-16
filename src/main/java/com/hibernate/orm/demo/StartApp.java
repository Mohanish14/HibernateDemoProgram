package com.hibernate.orm.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StartApp {
	public static void main(String[] args) {
		
		
		
		
		
		Product prod1 =new Product(1542, "tv", 5, 6115282.2, "SSS");
		Product prod2 =new Product(152, "v", 7, 1985282.2, "SS1S");
		Product prod3=new Product(142, "t", 6, 15256282.2, "SSS5");

		SessionFactory sf =HibernateConfig.getSessionFactoy();
		
		Session sess= sf.openSession();
		Transaction tt = sess.beginTransaction();
		sess.save(prod1);
		sess.save(prod2);
		sess.save(prod3);
		sess.flush();
		tt.commit();
		
		
	}

}
