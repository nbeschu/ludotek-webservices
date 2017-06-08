package com.nbeschu.database;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Factory de récupération de la session à la BDD
 * 
 * @author nbeschu
 *
 */
public class DaoFactory {
	/**
	 * le singleton de la session
	 */
	private static SessionFactory sessionFactory = null;

	/**
	 * getter
	 * 
	 * @return le singleton de la session
	 * @throws HibernateException
	 */
	public static SessionFactory getSessionFactory() throws HibernateException {

		if (sessionFactory == null) {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();

			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}

		return sessionFactory;
	}
}
