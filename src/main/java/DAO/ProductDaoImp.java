package DAO;

import Models.Product;
import org.hibernate.SessionFactory;

public class ProductDaoImp extends AbstractDao<Product> {
    public ProductDaoImp(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
