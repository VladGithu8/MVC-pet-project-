package Utils;

import DAO.CustomerDaoImp;
import Services.CustomerService;
import org.hibernate.SessionFactory;

public class DependencyContainer {

    //simple implementation of dependency management
    public static CustomerService getCustomerService() {
        return new CustomerService(getCustomerDao());
    }

    public static CustomerDaoImp getCustomerDao() {
        return new CustomerDaoImp(getSessionFactory());
    }

    public static SessionFactory getSessionFactory() {
        return  HibernateSessionFactoryUtil.getSessionFactory();
    }

}
