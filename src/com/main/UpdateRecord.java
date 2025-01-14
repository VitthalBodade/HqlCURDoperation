package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.entity.Employee;

public class UpdateRecord {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "update Employee set name =: myname, salary=:mysalary where empID=:myID";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("myname", "rakesh");
		query.setParameter("mysalary",40000);
		query.setParameter("myID", 1);
		query.executeUpdate();
		System.out.println("Data is updated.....");
		tr.commit();
		ss.close();	

	}

}
