package com.uc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
public static void main(String...args) {

	SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();  
	Session session=factory.getCurrentSession();
	try {
		session.beginTransaction();
		System.out.println("Delete instructor : ");
		int id=1;
		Instructor instructor=session.get(Instructor.class, id);
		if(instructor!=null) {
			System.out.println("Deleting : "+instructor);
			session.delete(instructor);
		}
		session.getTransaction().commit();
		System.out.println("Done");
	}

	finally {
		factory.close();
	}
}
}
