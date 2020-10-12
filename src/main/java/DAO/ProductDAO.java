package DAO;

import Models.Product;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductDAO extends DAOImpl {

    @Override
    public Product findById(int id) throws SessionException {
        return (Product) findById(id);
    }

    @Override
    public Product save(Object product) throws SessionException {
        return (Product) super.save(product);
    }

    @Override
    public Product delete(Object product) throws NoSuchElementException, SessionException {
        return (Product) super.delete(product);
    }

    @Override
    public Product update(Object product) throws NoSuchElementException, SessionException {
        return (Product) super.update(product);
    }

    @Override
    public List findAll() throws SessionException, SQLException, OutOfMemoryError {
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Customer").list();
        return new ArrayList<>(products);
    }

    public LinkedList<String> findAllProductsToString() throws OutOfMemoryError, SQLException {
        List<String> sqlProducts = new LinkedList<>();
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Product")
                .list();
        while (sqlProducts.size() != products.size()) {
            for (Product p : products) {
                int pId = Integer.valueOf(p.getId());
                String pDescription = String.valueOf(p.getDescription());
                double pPrice = Double.valueOf(p.getPrice());
                String pProductName = String.valueOf(p.getProductName());
                String pS = "\nId: " + pId + ", Product name: " + pProductName +
                        ", Product price: " + pPrice +
                        ", Description: " + pDescription;
                sqlProducts.add(pS);
            }
        }
        return (LinkedList<String>) sqlProducts;
    }
}
