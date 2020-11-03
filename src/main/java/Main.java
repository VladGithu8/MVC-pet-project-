import DAO.CustomerDaoImp;
import DAO.OrderDaoImp;
import DAO.ProductDaoImp;
import Models.Customer;

import Models.Order;
import Models.Product;
import Services.CustomerService;
import Services.OrderService;
import Services.ProductService;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Throwable {

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

        CustomerDaoImp customerDAO = new CustomerDaoImp(sessionFactory);
        CustomerService customerService = new CustomerService(customerDAO);

        ProductDaoImp productDaoImp = new ProductDaoImp(sessionFactory);
        ProductService productService = new ProductService(productDaoImp);

        OrderDaoImp orderDaoImp = new OrderDaoImp(sessionFactory);
        OrderService orderService = new OrderService(orderDaoImp);

        Customer customer = new Customer();

        customer.setFirstName("Pavel");
        customer.setLastName("Borchanskiy");
        customer.setAge(24);
        customer.setEmail("pav220011@gmail.com");
        customer.setPhone("0934456577");
        customerService.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Michail");
        customer1.setLastName("Vanish");
        customer1.setAge(44);
        customer1.setEmail("micha88@gmail.com");
        customer1.setPhone("0678894545");
        customerService.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Gosha");
        customer2.setLastName("Polevoi");
        customer2.setAge(21);
        customer2.setEmail("palev1@gmail.com");
        customer2.setPhone("0505679898");
        customerService.save(customer2);


        Product product = new Product();
        product.setProductName("Phone mi2");
        product.setPrice(12800);
        product.setDescription("The beast middle coast phone");
        productService.save(product);

        Product product1 = new Product();
        product1.setProductName("Phone MIX6");
        product1.setPrice(7000);
        product1.setDescription("The beast cheap phone");
        productService.save(product1);

        Product product2 = new Product();
        product2.setProductName("Phone Iphone");
        product2.setPrice(32300);
        product2.setDescription("Top of the year");
        productService.save(product2);

        Product product3 = new Product();
        product3.setProductName("Smart watch SmartGear");
        product3.setPrice(11000);
        product3.setDescription("Whole world on your hand");
        productService.save(product3);

        Product product4 = new Product();
        product4.setProductName("Smart watch AppleWatch");
        product4.setPrice(18800);
        product4.setDescription("Now Apple in your hand and on it!");
        productService.save(product4);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        productList.add(product2);
        productList.add(product4);

        List<Product> productList1 = new ArrayList<Product>();
        productList1.add(product2);
        productList1.add(product);
        productList1.add(product1);
        productList1.add(product3);

        List<Product> productList2 = new ArrayList<Product>();
        productList2.add(product1);
        productList2.add(product3);


        Order order = new Order();
        order.setProductList(productList);
        order.setCustomer(customer);
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(order);
        customer.getOrder(orderList);

        Order order1 = new Order();
        order1.setProductList(productList1);
        order1.setCustomer(customer1);
        List<Order> orderList1 = new ArrayList<Order>();
        orderList1.add(order1);
        customer1.getOrder(orderList1);

        Order order2 = new Order();
        order2.setProductList(productList2);
        order2.setCustomer(customer2);
        List<Order> orderList2 = new ArrayList<Order>();
        orderList2.add(order2);
        customer2.getOrder(orderList2);

        orderService.save(order);
        orderService.save(order1);
        orderService.save(order2);

//        For your tests
//       customerService.update(customerService.findById(1).setFirstName("Goods"));
//       customerService.delete(customerService.findById(2));
//
//       productService.delete(productService.findById(1));
    }
}
