package DAO;

import Models.*;
import Utils.HibernateSessionFactoryUtil;
import Utils.SessionUtilDAO;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CustomerDAO {

   private SessionUtilDAO sessionUtilDAO;
   public CustomerDAO() { sessionUtilDAO = new SessionUtilDAO();}

    public Customer findById(int id) throws Exception {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);}

    public boolean saveCustomer(Customer customer) {
        sessionUtilDAO.save(customer);
        System.out.println("Customer saved :" + customer);
        return true;}

    public boolean updateCustomer(Customer customer) throws Exception {
        sessionUtilDAO.update(customer);
        System.out.println("Customer updated :" + customer);
        return true;}

    public boolean deleteCustomer(Customer customer) throws Exception {
        sessionUtilDAO.delete(customer);
        System.out.println("Customer deleted :" + customer);
        return true;}

    public List<String> findAllCustomers() throws IOException {
        List<String> sqlCustomers = new LinkedList<>();
        List<Customer> customers = (List<Customer>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Customer")
                .list();
        while (sqlCustomers.size() != customers.size()){
            for (Customer customer:customers) {
                int customerId = Integer.valueOf(customer.getId());
                String customerFirstName = String.valueOf(customer.getFirstName());
                String customerLastName = String.valueOf(customer.getLastName());
                int customerAge = Integer.valueOf(customer.getAge());
                String customerEmail = String.valueOf(customer.getEmail());
                String customerPhone = String.valueOf(customer.getPhone());
                String customersInfo = "\nId: " + customerId + ", Customer first name: " + customerFirstName +
                        ", last name: " + customerLastName + ", Age: " + customerAge+", Email:" +customerEmail+
                        ", Phone:" + customerPhone;
                sqlCustomers.add(customersInfo);}
        } return (LinkedList<String>) sqlCustomers;
    }
}
