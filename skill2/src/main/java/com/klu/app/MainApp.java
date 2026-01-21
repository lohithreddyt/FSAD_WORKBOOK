package com.klu.app;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.model.Product;
import com.klu.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
        Product p2 = new Product("Phone", "Android Phone", 25000, 20);
        Product p3 = new Product("Headset", "Wireless Headset", 3000, 50);

        session.save(p1);
        session.save(p2);
        session.save(p3);

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully");
    }
}

