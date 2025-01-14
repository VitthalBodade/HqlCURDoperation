package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Employee;

public class InsertRecord {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "insert into Employee(salary,name,Domain)values(:mysalary,:myname,:myDomain)";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("myname", "yogesh");
		query.setParameter("mysalary", 37500);
		query.setParameter("myDomain", "game developer");
		query.setParameter("myname", "raj");
		query.setParameter("mysalary", 55500);
		query.setParameter("myDomain", "full stack developer");
		query.executeUpdate();
		System.out.println("data is inserted......");
		tr.commit();
		ss.close();

		
		
		
	
	}

}
