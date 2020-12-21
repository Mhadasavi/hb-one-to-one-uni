package com.uc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
public static void main(String...args) {

	SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();  
	Session session=factory.getCurrentSession();
	try {
		session.beginTransaction();
		Instructor tempInstructor=new Instructor("Ravi","chaudhary","ravi@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("secondYoutubeChannel","GTA4");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("saving instructor : "+tempInstructor);
		session.save(tempInstructor);
		session.getTransaction().commit();
		System.out.println("Done");
	}

	finally {
		factory.close();
	}
}
}
