package com.pablousegreenhibernate.hibernate_demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        AlienName aname = new AlienName();
        aname.setFname("Lopez");
        aname.setLname("Ruiz");
        aname.setMname("Ximena");
      
        Alien alien = new Alien();
        alien.setAid(6);
        alien.setAname(aname);
        
    	Laptop lap = new Laptop();
    	lap.setLid(101);
    	lap.setBrand("Mac");
    	lap.setPrice(5000);
    	lap.setAlien(alien);
    	
    	alien.getLaps().add(lap);
    	
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setName("Marco");
    	student.setMarks(50);
    	student.getLaptops().add(lap);  //for ManyToMany
//    	lap.setStudent(student); //for ManyToOne
    	//lap.getStudents().add(student); //for ManyToMany
    	
    	//other way to configure entities are : new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class); //For ManyToMany
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        session.beginTransaction();
        session.save(alien); //for new Insert object entity
        session.save(lap); //for new Insert object entity
        //alien = (Alien)session.get(Alien.class, 1);  // for getting a specific object
//        session.save(lap);  //For ManyToMany
        session.save(student); //ForManyToMany
        
//        alien = (Alien)session.get(Alien.class, 1);
//        System.out.println("ALIEN IS : "+alien);
//        
//        Collection<Laptop> laps = alien.getLaps();
//        laps.forEach(action->{
//        	System.out.println(action);
//        });
        
        session.getTransaction().commit();	
//        System.out.println(alien);
    }
}
