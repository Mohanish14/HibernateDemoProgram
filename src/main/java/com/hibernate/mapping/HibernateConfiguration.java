package com.hibernate.mapping;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration {

	static private SessionFactory sfactory = null;

	Configuration connection = new Configuration();

	public static SessionFactory getSessionfactory(Class... classes) {
		if (sfactory == null) {
			Configuration configure = new Configuration();
			configure.setProperties(mySqlDatabaseConfiguration());
			for (Class cls : classes) { // 2 times -->
				configure.addAnnotatedClass(cls); // prod.class,ven.class
			}

			ServiceRegistry serviceRegistery = new StandardServiceRegistryBuilder()
					.applySettings(configure.getProperties()).build();
			sfactory = configure.buildSessionFactory(serviceRegistery);
		}

		return sfactory;
	}

	public static Properties mySqlDatabaseConfiguration() {
		Properties props = new Properties();
		props.put(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(AvailableSettings.URL, "jdbc:mysql://localhost/hibdb");
		props.put(AvailableSettings.USER, "root");
		props.put(AvailableSettings.PASS, "root");
		props.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		props.put(AvailableSettings.HBM2DDL_AUTO, "create");
		props.put(AvailableSettings.SHOW_SQL, true);
		props.put(AvailableSettings.FORMAT_SQL, true);
		props.put(AvailableSettings.USE_SECOND_LEVEL_CACHE, true);
		props.put(AvailableSettings.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
		props.put(AvailableSettings.USE_QUERY_CACHE, true);
		return props;
	}

}
