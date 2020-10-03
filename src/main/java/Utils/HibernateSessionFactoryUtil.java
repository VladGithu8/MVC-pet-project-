package Utils;

import Models.*;

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
            } catch (Exception e) {
                System.out.println("Get EXCEPTION" + e);

            }

        }
            return sessionFactory;
    }

}



//    private static SessionFactory sessionFactory = createSessionFactory();
//
//    private static SessionFactory createSessionFactory() {
//        if (sessionFactory == null) {
//            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//            sessionFactory = metaData.getSessionFactoryBuilder().build();
//        }
//        return sessionFactory;
//    }

//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void shutdown() {
//        sessionFactory.getCurrentSession().close();

