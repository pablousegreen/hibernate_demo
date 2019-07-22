package com.pablousegreenhibernate.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        System.out.println( "Hello World!" );
        AlienName aname = new AlienName();
        aname.setFname("Lopez");
        aname.setLname("Ruiz");
        aname.setMname("Ximena");
        
        Alien alien = new Alien();
        alien.setAid(6);
        alien.setAname(aname);
        alien.setColor("yellow");
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        Transaction tr = session.beginTransaction();
        session.save(alien); //for new Insert object entity
        //alien = (Alien)session.get(Alien.class, 1);  // for getting a specific object
        tr.commit();	
//        System.out.println(alien);
    }
}
