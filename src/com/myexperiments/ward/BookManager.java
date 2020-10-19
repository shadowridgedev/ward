package com.myexperiments.ward;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BookManager {
	protected SessionFactory sessionFactory;
	protected Session session;

	protected void setup() {
		// code to load Hibernate Session factory
		// String cfgpath = System.getProperty("user.dir") + "/hibernate.cfg.xml";
		String cfgpath = "src/hibernate.cfg.xml";
		/*
		 * final StandardServiceRegistry registry = new
		 * StandardServiceRegistryBuilder().configure(cfgpath).build(); try {
		 * sessionFactory = new
		 * MetadataSources(registry).buildMetadata().buildSessionFactory(); } catch
		 * (Exception ex) { StandardServiceRegistryBuilder.destroy(registry); }
		 */

		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();

	}

	protected void exit() {
		// code to close Hibernate Session factory
		session.close();
	}

	protected void create(Book book) {
		// code to save a book

		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();

	}

	protected void read() {
		// code to get a book
	}

	protected void update() {
		// code to modify a book
	}

	protected void delete() {
		// code to remove a book
	}

}