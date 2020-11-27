package Utils;

import Models.Customer;
import Models.Order;
import Models.Product;

import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws SessionException {
        GetEnv getEnv = new GetEnv();
        String a, b;
        a = getEnv.getEnvLogin();
        b = getEnv.getEnvPass();

        if (sessionFactory == null) {
            try {
                        Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
                        .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mvctest")
                        .setProperty("hibernate.show_sql", "true")
                        .setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect")
                        .setProperty("hibernate.hbm2ddl.auto","update")
                        .setProperty("default_entity_mode", "dynamic-map")
                        .setProperty("hibernate.connection.username", a )
                        .setProperty("hibernate.connection.password", b )
                        .addAnnotatedClass(Order.class)
                        .addAnnotatedClass(Customer.class)
                        .addAnnotatedClass(Product.class);

                StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(build);
                System.out.println(sessionFactory);
                return sessionFactory ;
            } catch (SessionException sE) {
                throw sE;
            }
        } else{
            return sessionFactory;
        }
    }
}


