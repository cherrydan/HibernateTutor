package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Item.class).buildSessionFactory();

        Session session = null;
        // == CREATE ==
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item item = new Item("Milk", 80);
//        System.out.println(item);
//        session.save(item);
//        session.getTransaction().commit();
//        System.out.println(item);
//        sessionFactory.close();

        // == READ
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.get(Item.class, 1L);
        System.out.println(itemFromDb);
        session.getTransaction().commit();

        // == UPDATE
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb2 = session.get(Item.class, 1L);
        System.out.println(itemFromDb2);
        itemFromDb2.setPrice(200);
        System.out.println(itemFromDb2);
        session.getTransaction().commit();


    sessionFactory.close();


    }
}
