package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Employee;

public class DeleteRecord {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "delete from Employee where empID=:myID";
		int myID= 2;
		Query<Employee> query = ss.createQuery(hqlQuery);
		query.setParameter("myID", myID);
		query.executeUpdate();
		System.out.println("data is deleted.....");
		tr.commit();
		ss.close();
	}

}
