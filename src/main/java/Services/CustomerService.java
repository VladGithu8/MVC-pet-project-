package Services;

import DAO.CustomerDaoImp;
import Models.Customer;
import org.hibernate.exception.ConstraintViolationException;

public class CustomerService extends AbstractService<Customer, CustomerDaoImp>  {

    public CustomerService(CustomerDaoImp entity) {
        super(entity);
    }
}

