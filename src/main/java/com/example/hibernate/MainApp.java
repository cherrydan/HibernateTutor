package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Item.class).buildSessionFactory();

        Session session = null;
        // == CREATE ==
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item item = new Item("Milk", 80);
        session.save(item);

        session.getTransaction().commit();

        sessionFactory.close();

    }
}
