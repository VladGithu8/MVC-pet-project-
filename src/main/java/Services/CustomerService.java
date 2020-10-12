package Services;

import DAO.CustomerDAOImp;
import Models.Customer;

import java.sql.SQLException;

public class CustomerService {

    private final CustomerDAOImp customerDAO;

    public CustomerService(CustomerDAOImp customerDAO) {
        this.customerDAO = customerDAO;
    }

//
//    public Customer findCustomerById(int id) throws SQLException, NoSuchElementException {
//        return customerDAO.findById(id);
//    }
//
    public Customer saveCustomer(Customer customer) throws SQLException {
        return customerDAO.save(customer);
    }
//
//    public Customer deleteCustomer(Customer customer) throws SQLException, NoSuchElementException {
//        return customerDAO.delete(customer);
//    }
//
//    public Customer updateCustomer(Customer customer) throws SQLException,NoSuchElementException {
//        return customerDAO.update(customer);
//    }
//
//    public List findAllCustomers() throws SQLException {
//        return customerDAO.findAll();
//    }
//    public List<String> findAllCustomersToString() throws SQLException {
//        return customerDAO.findAllCustomersToString();
//    }
}
