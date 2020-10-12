package DAO;

import Models.Customer;

import Utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomerDAO extends DAOImpl{

    @Override
    public Customer findById(int id) throws SessionException {
        return (Customer) findById(id);
    }

    @Override
    public Customer save(Object customer) throws SessionException {
        return (Customer) super.save(customer);
    }

    @Override
    public Customer delete(Object customer) throws NoSuchElementException, SessionException {
        return (Customer) super.delete(customer);
    }

    @Override
    public Customer update(Object customer) throws NoSuchElementException, SessionException {
        return (Customer) super.update(customer);
    }

    @Override
    public List findAll() throws SessionException, SQLException, OutOfMemoryError {
        List<Customer> customers = (List<Customer>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Customer").list();
        return new ArrayList<>(customers);
    }

    public List<String> findAllCustomersToString() throws SQLException, OutOfMemoryError {
        List<String> sqlCustomers = new LinkedList<>();
        List<Customer> customers = (List<Customer>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Customer")
                .list();
        while (sqlCustomers.size() != customers.size()) {
            for (Customer customer : customers) {
                int customerId = Integer.valueOf(customer.getId());
                String customerFirstName = String.valueOf(customer.getFirstName());
                String customerLastName = String.valueOf(customer.getLastName());
                int customerAge = Integer.valueOf(customer.getAge());
                String customerEmail = String.valueOf(customer.getEmail());
                String customerPhone = String.valueOf(customer.getPhone());
                String customersInfo = "\nId: " + customerId + ", Customer first name: " + customerFirstName +
                        ", last name: " + customerLastName + ", Age: " + customerAge + ", Email:" + customerEmail +
                        ", Phone:" + customerPhone;
                sqlCustomers.add(customersInfo);
            }
        }
        return (LinkedList<String>) sqlCustomers;
    }
}
