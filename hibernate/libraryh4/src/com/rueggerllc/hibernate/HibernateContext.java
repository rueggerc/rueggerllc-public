package com.rueggerllc.hibernate;

import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateContext {
	private static Logger logger = Logger.getLogger(HibernateContext.class);
	private static HibernateContext instance;
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	
	private HibernateContext() {
		URL configFileURL = HibernateContext.class.getResource("/resources/hibernate.cfg.xml");
		Configuration config = new Configuration().configure(configFileURL);
		loadAnnotatedClasses(config);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
	private void loadAnnotatedClasses(Configuration config) {
		try {
			Properties props = new Properties();
			config.addProperties(props);
			config.addAnnotatedClass(com.rueggerllc.beans.Pet.class);
			config.addAnnotatedClass(com.rueggerllc.beans.PetDetails.class);
			config.addAnnotatedClass(com.rueggerllc.beans.Account.class);
			config.addAnnotatedClass(com.rueggerllc.beans.Student.class);
			config.addAnnotatedClass(com.rueggerllc.beans.Course.class);
		} catch (Exception e) {
			logger.error("ERROR Initializing Hibernate", e);
		}
	}

	public static HibernateContext getInstance() {
		if (instance != null) {
			return instance;
		}
		instance = new HibernateContext();
		return instance;
	}
	
	public static Session getCurrentSession() throws HibernateException {
		return getInstance().sessionFactory.getCurrentSession();
	}
	
	public static void closeCurrentSession() throws HibernateException {
		getInstance().sessionFactory.getCurrentSession().close();
	}
    

}
