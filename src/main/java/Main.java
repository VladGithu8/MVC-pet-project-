import DAO.CustomerDAOImp;
import DAO.ProductDaoImp;
import Models.Customer;
import Models.Product;

import Services.CustomerService;
import Services.ProductService;
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

        ProductDaoImp productDaoImp =  new ProductDaoImp(sessionFactory);
        ProductService  productService =  new ProductService(productDaoImp);

//        ProductService productService = new ProductService();
//        OrderCartService orderCartService = new OrderCartService();

//        List<Product> products = new ArrayList<>();
//        List<Product> products1 = new ArrayList<>();
//        List<Product> products2 = new ArrayList<>();

        Customer customer = new Customer("Evgen","Borovoi",25,"0932223344","BorEv@gmail.com");
        Customer customer1 = new Customer("Semen","Korobkin",34,"0603335566","SemenKorobkin@gmail.com");
        Customer customer2 = new Customer("Gamaz","Zamaz",19,"0501110099","GAMAZ@gmail.com");

        List<Customer> customerList  = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);

        List<Customer> results = customerList.stream().map(cust -> {
            try {
                return customerService.saveCustomer(cust);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());

        results.forEach(System.out::println);


        Product mi = new Product("Xiaomy","Super phone",12900);
        productService.saveProduct(mi);

        Customer customer3 = new Customer();

//        Product mi1 = new Product("12Xiaomy","11Super phone",16800);
//        Product mi2 = new Product("999Xiaomy","22Super phone",20200);
//        productService.saveProduct(mi);
//        productService.saveProduct(mi1);
//        productService.saveProduct(mi2);
//
//        System.out.println(productService.findAllProducts());
//        System.out.println(productService.findAllProductsToString());

//        System.out.println(customerService.findAllCustomers());
//        System.out.println(customerService.findAllCustomersToString());
    }
}
