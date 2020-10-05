package DAO;

import Models.*;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAO {

    public CustomerDAO() {

    }

    public Customer findById(int id) throws Exception {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);

    }

    public void saveCustomer(Customer cust) {
        Session session = null;
        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {

            session = sessionFactory.openSession();
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.save(cust);
            t1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public void updateCustomer(Customer cust) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.update(cust);
        t1.commit();
        session.close();

    }

    public void deleteCustomer(Customer cust) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.delete(cust);
        t1.commit();
        session.close();
    }

    public List<Customer> findAllCustomers() throws Exception {
        List<Customer> cust = (List<Customer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("SELECT * FROM Customer").list();
        return cust;
    }
}
