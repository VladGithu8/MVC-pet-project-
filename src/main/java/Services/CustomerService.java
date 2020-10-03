package Services;

import DAO.CustomerDAO;
import Models.Customer;


import java.util.List;

public class CustomerService {


    private CustomerDAO customerDAO = new CustomerDAO();



    public Customer findCustomer(int id) throws Exception {
        return customerDAO.findById(id);
    }
    public void saveCustomer(Customer cust) throws Exception {
        customerDAO.saveCustomer(cust);
    }
    public void deleteCustomer(Customer cust) throws Exception {
        customerDAO.deleteCustomer(cust);
    }
    public void updateCustomer(Customer cust) throws Exception {
        customerDAO.updateCustomer(cust);
    }
    public List<Customer> findAllCustomers() throws Exception{
        return customerDAO.findAllCustomers();

    }
}
