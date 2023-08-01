package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Item.class).buildSessionFactory();

        Session session;
        // == CREATE ==
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item item = new Item("Milk", 80);
//        System.out.println(item);
//        session.save(item);
//        session.getTransaction().commit();
//        System.out.println(item);
//        sessionFactory.close();

//        // == READ
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.get(Item.class, 1L);
//        System.out.println(itemFromDb);
//        session.getTransaction().commit();

        // == UPDATE
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb2 = session.get(Item.class, 1L);
//        System.out.println(itemFromDb2);
//        itemFromDb2.setPrice(200);
//        System.out.println(itemFromDb2);
//        itemFromDb2.setTitle("Bread");
//        itemFromDb2.setPrice(250);
//        System.out.println(itemFromDb2);
//        session.getTransaction().commit();

        // == DELETE
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.createQuery("SELECT i FROM Item i WHERE i.id = 1",
                Item.class).getSingleResult();
        System.out.println(itemFromDb);

        List<Item> items = session.createQuery("SELECT i FROM Item i",
                        Item.class).getResultList();
        System.out.println(items);
        session.getTransaction().commit();


    sessionFactory.close();


    }
}
