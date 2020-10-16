package Services;

import DAO.CustomerDAOImp;
import Models.Customer;

public class CustomerService extends AbstractService<Customer, CustomerDAOImp>  {

    public CustomerService(CustomerDAOImp entity) {
        super(entity);
    }
}
