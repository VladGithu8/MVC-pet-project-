package Services;

import DAO.CustomerDAO;
import Models.Customer;
import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO;
    public CustomerService() {customerDAO= new CustomerDAO();}

    public boolean findCustomer(int id) throws Exception {
        customerDAO.findById(id);
        System.out.println(id);
        return true;}

    public boolean saveCustomer(Customer customer) throws Exception {
        customerDAO.saveCustomer(customer);
        return true;}

    public boolean deleteCustomer(Customer customer) throws Exception {
        customerDAO.deleteCustomer(customer);
        return true;}

    public boolean updateCustomer(Customer customer) throws Exception {
        customerDAO.updateCustomer(customer);
        return true;}

    public List<String> findAllCustomers() throws Exception{
        return customerDAO.findAllCustomers();}
}
