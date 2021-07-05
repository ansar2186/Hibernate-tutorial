package com.ansar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started-----!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Employee employee = new Employee();
		employee.setId(001);
		employee.setEmpName("Ansar");
		employee.setDesignation("Software Enginner");
		System.out.println("Employee obj-------" + employee);
		// address object created;

		EmpAddress obj = new EmpAddress();
		obj.setAddedDate(new Date());
		obj.setCity("delhi");
		obj.setCountry("INDIA");
		obj.setState("UP");

		FileInputStream fis = new FileInputStream("src/main/java/ansar.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		obj.setImage(data);

		System.out.println(" Address Object---------" + obj);

		Session session = factory.openSession();
		// Transaction used only when we save the java object in the datadase.
		Transaction transaction = session.beginTransaction();

		session.save(employee);
		session.save(obj);

		transaction.commit();
		session.close();

		System.out.println(" ---data saved--");

	}
}
