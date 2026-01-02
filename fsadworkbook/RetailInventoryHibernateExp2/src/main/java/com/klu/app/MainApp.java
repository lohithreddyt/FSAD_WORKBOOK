package com.klu.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.model.Product;
import com.klu.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {
        insertProducts();
        getProduct(1);
        updateProduct(1);
        deleteProduct(2);
    }

    public static void insertProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "HP i5", 65000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 800, 50);
        Product p3 = new Product("Keyboard", "Mechanical Keyboard", 2500, 20);

        session.save(p1);
        session.save(p2);
        session.save(p3);

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully");
    }

    public static void getProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        System.out.println("Retrieved: " + product);
        session.close();
    }

    public static void updateProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);
        product.setPrice(70000);
        product.setQuantity(8);

        tx.commit();
        session.close();

        System.out.println("Product updated");
    }

    public static void deleteProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);
        session.delete(product);

        tx.commit();
        session.close();

        System.out.println("Product deleted");
    }
}
