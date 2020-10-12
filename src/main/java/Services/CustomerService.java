package Services;

import DAO.CustomerDAO;
import Models.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public Customer findCustomerById(int id) throws SQLException, NoSuchElementException {
        return customerDAO.findById(id);
    }

    public Customer saveCustomer(Customer customer) throws SQLException {
        return customerDAO.save(customer);
    }

    public Customer deleteCustomer(Customer customer) throws SQLException, NoSuchElementException {
        return customerDAO.delete(customer);
    }

    public Customer updateCustomer(Customer customer) throws SQLException,NoSuchElementException {
        return customerDAO.update(customer);
    }

    public List findAllCustomers() throws SQLException {
        return customerDAO.findAll();
    }
    public List<String> findAllCustomersToString() throws SQLException {
        return customerDAO.findAllCustomersToString();
    }
}
