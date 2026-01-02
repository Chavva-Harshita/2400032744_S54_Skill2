package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Product;
import util.User;

import java.util.List;

public class ProductDAO {

    // ✅ CREATE / INSERT
    public void saveProduct(Product product) {
        Transaction tx = null;

        try (Session session = ((SessionFactory) User.getSessionFactory()).openSession()) {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ READ by ID
    public Product getProductById(int pid) {
        try (Session session = User.getSessionFactory().openSession()) {
            return session.get(Product.class, pid);
        }
    }

    // ✅ READ ALL
    public List<Product> getAllProducts() {
        try (Session session = User.getSessionFactory().openSession()) {
            return session.createQuery("from Product", Product.class).list();
        }
    }

    // ✅ UPDATE
    public void updateProduct(Product product) {
        Transaction tx = null;

        try (Session session = User.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ DELETE
    public void deleteProduct(int pid) {
        Transaction tx = null;

        try (Session session = User.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Product product = session.get(Product.class, pid);
            if (product != null) {
                session.delete(product);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
