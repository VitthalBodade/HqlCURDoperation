package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Employee;

public class GetAllRecord {
public static void main(String[] args) {
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Employee.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();
	Transaction tr = ss.beginTransaction();
	
	String HqlQuery = "from Employee";
	Query<Employee> query= ss.createQuery(HqlQuery,Employee.class);
	List<Employee> list = query.getResultList();
	
	for(Employee Emp:list) {
		System.out.println(Emp);
	}
	
	
}
}
