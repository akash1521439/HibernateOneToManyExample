package com.demo.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.demo.model.Course;
import com.demo.model.Trainer;
import com.demo.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trainer trainer = new Trainer("ABC","CSE");
		Trainer trainer1 = new Trainer("BCD","EEE");
		
		Course course = new Course("Java");
		Course course1 = new Course("JDBC");
		Course course2 = new Course("Hibernate");
		Course course3 = new Course("Java");
		Course course4 = new Course("JDBC");
		Course course5 = new Course("Hibernate");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.getTransaction().begin();
		session.save(trainer);
		session.save(trainer1);
		
		course.setTrainer(trainer);
		course1.setTrainer(trainer1);
		course2.setTrainer(trainer); 
		
		session.save(course);
		session.save(course1);
		session.save(course2);
		
		course3.setTrainer(trainer1);
		course4.setTrainer(trainer1);
		course5.setTrainer(trainer1);
		session.save(course3);
		session.save(course4);
		session.save(course5);
		
		trainer = session.get(Trainer.class, 1);
		System.out.println(trainer);
		course = session.load(Course.class, 1);
		System.out.println(course);
		session.getTransaction().commit();
		
		String hql = "from Trainer t inner join t.course ";
		Query query = session.createQuery(hql);
		
		List<Object []> listResults = query.getResultList();
		for(Object arr [] : listResults) {
			Trainer t = (Trainer) arr[0];
			Course c = (Course) arr[1];
			System.out.println(t.getName()+"::"+c.getCourseName());
		}
		

	}

}
