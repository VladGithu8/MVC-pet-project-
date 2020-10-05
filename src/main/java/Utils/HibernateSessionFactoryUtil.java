package Utils;

import Models.Customer;
import Models.OrderCart;
import Models.Product;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(OrderCart.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Product.class);

                configuration.configure();
                StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                SessionFactory sessionFactory = configuration.buildSessionFactory(build);
                System.out.println(sessionFactory);
                return sessionFactory;

            } catch (Exception e){ System.out.println("Get EXCEPTION" + e); }
        } 
       return sessionFactory;
    }
}
