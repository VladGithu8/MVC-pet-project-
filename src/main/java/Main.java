import DAO.CustomerDAOImp;
import DAO.ProductDaoImp;
import Models.Customer;
import Models.Product;

import Services.CustomerService;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        CustomerDAOImp customerDAO = new CustomerDAOImp(sessionFactory);
        CustomerService customerService = new CustomerService(customerDAO);


        Customer customer = new Customer("Evgen","Borovoi",25,"0932223344","BorEv@gmail.com");
        Customer customer1 = new Customer("Semen","Korobkin",34,"0603335566","SemenKorobkin@gmail.com");
        Customer customer2 = new Customer("Gamaz","Zamaz",19,"0501110099","GAMAZ@gmail.com");

        List<Customer> customerList  = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);

        List<Customer> results = customerList
                .stream()
                .map(customerService::save)
                .collect(Collectors.toList());

        results.forEach(System.out::println);

    }
}
