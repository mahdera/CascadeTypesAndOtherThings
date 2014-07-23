package com.mahder.hibernate.cascadetypesandother.study;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestProject {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//now create the objects and persist them to the database...
		Department department = new Department();
		department.setDepartmentName("Information Science");
		department.setDescription("this is the description...");
		
		Teacher teacher1 = new Teacher();
		Teacher teacher2 = new Teacher();
		teacher1.setFullName("Mahder Neway");
		teacher1.setDepartment(department);
		teacher2.setFullName("Betsegaw Dereje");
		teacher2.setDepartment(department);
		//now link the teachers to the Department instance...
		department.getTeacherList().add(teacher1);
		department.getTeacherList().add(teacher2);
		
		//now its time to save this information to the database...
		session.persist(department);
		session.getTransaction().commit();
		session.close();
		System.out.println("Done saving objects to the database...");
	}

}//end class
