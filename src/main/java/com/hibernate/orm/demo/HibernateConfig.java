package com.hibernate.orm.demo;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {
	static private SessionFactory sfactory ;

public static SessionFactory getSessionFactoy() {
	if (sfactory==null) {
		Configuration connection = new Configuration();
		
		Properties prop = new Properties();
		prop.put(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");
		prop.put(AvailableSettings.URL,"jdbc:mysql://localhost/hibdb");
		prop.put(AvailableSettings.USER,"root");
		prop.put(AvailableSettings.PASS,"root");
		prop.put(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
		prop.put(AvailableSettings.HBM2DDL_AUTO,"create");
		prop.put(AvailableSettings.SHOW_SQL,true);
		
		connection.setProperties(prop);
		connection.addAnnotatedClass(Product.class);
		
		ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(connection.getProperties()).build();
		
		sfactory = connection.buildSessionFactory(service);
	}
	
	
	return sfactory;
	
}


}
