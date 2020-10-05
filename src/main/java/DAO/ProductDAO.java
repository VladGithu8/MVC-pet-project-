package DAO;

import Models.Product;
import Models.OrderCart;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {

public ProductDAO() {}

    public Product findById(int id) throws Exception {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    public void saveProduct(Product product) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.save(product);
        t1.commit();
        session.close();
    }

    public void updateProduct(Product product) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.update(product);
        t1.commit();
        session.close();
    }

    public void deleteProduct(Product product) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.delete(product);
        t1.commit();
        session.close();
    }

    public OrderCart findCartById(int id) throws Exception {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OrderCart.class, id);
    }

    public List<Product> findAllProducts() throws Exception {
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("SELECT * FROM Products").list();
        return products;
    }
}

