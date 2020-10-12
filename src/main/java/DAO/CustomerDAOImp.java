package DAO;

import Models.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAOImp extends AbstractDao<Customer>  {

    public CustomerDAOImp(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
