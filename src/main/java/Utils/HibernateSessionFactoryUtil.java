package Utils;

import Models.Customer;
import Models.Order;
import Models.Product;

import org.hibernate.PersistentObjectException;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws PersistentObjectException, SessionException {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Product.class);

                configuration.configure();
                StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                SessionFactory sessionFactory = configuration.buildSessionFactory(build);
                System.out.println(sessionFactory);
                return sessionFactory;
            } catch (Exception e) {
                System.out.println("Get EXCEPTION" + e);
            }
        } return sessionFactory;
    }
}

