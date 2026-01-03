package com.klu.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;
public class ProductDAO {
    public void addProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }
}