package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Employee;

public class GetSingleRecord {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Employee where empID=:myID ";
		Query<Employee> query = ss.createQuery(HqlQuery, Employee.class);
		query.setParameter("myID", 1);
		Employee e = query.getSingleResult();
		System.out.println(e);

	}
}
