package com.anurag.DemoHibernate;



import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
//        Alien me = new Alien();
//        AlienName an = new AlienName();
//        an.setfName("Anurag");
//        an.setlName("Porwal");
//        an.setmName("Kumar");
    	
//     	  me.setAid(110);
//        me.setAname(an);
//        me.setColor("Brown");
////      Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
//      Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
////      SessionFactory sf = con.buildSessionFactory(); old method
//      ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); //new methods
//      SessionFactory sf = con.buildSessionFactory(reg); // new method
    	
//        Session session = sf.openSession();
//        
//        Transaction tx = session.beginTransaction();
//        
////        me = (Alien)session.get(Alien.class, 108); // get return type is object we need to typecaste to Alien another method is load
//        session.save(me);
//        tx.commit();
//        System.out.println(me);
// ------------------------------------------------------------------    
 /*   	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
        
        Student s = new Student();
        s.setName("Anurag");
        s.setRollno(2);
        s.setMarks(50);
        s.getLaptop().add(laptop);
        laptop.setStudent(s);
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); //new methods
        SessionFactory sf = con.buildSessionFactory(registry); // new method

        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(laptop);
        session.save(s);
        session.getTransaction().commit();
//        System.out.println(me);
 //---------------------------------------------------------------       
 */
    	/*
    	//caching level 2
    	Alien alien = new Alien();
    	alien.setAid(1);
        alien.setAname("Anurag");
        alien.setColor("White");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); //new methods
        SessionFactory sf = con.buildSessionFactory(registry); // new method
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        
 
        System.out.println(alien);
//        session.save(alien);
////              
//        Alien a1 = (Alien)session.get(Alien.class, 1);
        Query q1 = session.createQuery("from Alien where aid=1");
        q1.setCacheable(true);
        
        Alien a1 = (Alien)q1.uniqueResult();
        System.out.println(a1);
        session.getTransaction().commit();
        session.close();

        
        Session session2 = sf.openSession();
        session2.beginTransaction();
//        Alien a2 = (Alien)session2.get(Alien.class, 1); // 
        Query q2 = session2.createQuery("from Alien where aid=1"); //query caching level 2 also we need to mention in hibernate.cfg.xml file
        q2.setCacheable(true);
        a1 = (Alien)q2.uniqueResult();
        System.out.println(a1);
        session2.getTransaction().commit();
        session2.close();
        
        //query caching
        
//        
//        a = (Alien) session2.get(Alien.class, 101); 
 */
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); //new methods
        SessionFactory sf = con.buildSessionFactory(registry); // new method
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        /* Table generation
        Random r = new Random();
        for(int i = 1; i<=50; i++)
        {
        	Student s = new Student();
        	s.setRollno(i);
        	s.setName("Name " + i);
        	s.setMarks(r.nextInt(100));
        	session.save(s);
        }
        
        session.getTransaction().commit();
        */
        int b = 90;
        Query q = session.createQuery("select rollno, name, marks from Student where marks < 90"); //this is hql, note intead of table name write class name.
//        q.setParameter("b", b);
        List<Object[]> students = (List<Object[]>)q.list();  // when output is single use q.uniqueResult();
        
        for(Object[] : students)
        {
        	System.out.println(s);
        }
        
        
    }
}


// For a session we can use level one cache but as we close that session we cant access from level 1 cache so we use level 2 cache
