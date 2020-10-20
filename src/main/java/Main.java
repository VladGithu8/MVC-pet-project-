//import DAO.CustomerDaoImp;
//import DAO.OrderCartDaoImp;
//import DAO.ProductDaoImp;
//import Models.Customer;
//
//import Models.OrderCart;
//import Models.Product;
//import Services.CustomerService;
//import Services.OrderCartService;
//import Services.ProductService;
//import Utils.HibernateSessionFactoryUtil;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Order;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//
//        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
//
//        CustomerDaoImp customerDAO = new CustomerDaoImp(sessionFactory);
//        CustomerService customerService = new CustomerService(customerDAO);
//
//        ProductDaoImp productDaoImp = new ProductDaoImp(sessionFactory);
//        ProductService productService = new ProductService(productDaoImp);
//
//        OrderCartDaoImp orderCartDaoImp = new OrderCartDaoImp(sessionFactory);
//        OrderCartService orderCartService = new OrderCartService(orderCartDaoImp);
//
//        Customer customer = new Customer("Evgen","Borovoi",25,"0932223344","BorEv@gmail.com");
//        Customer customer1 = new Customer("Semen","Korobkin",34,"0603335566","SemenKorobkin@gmail.com");
//        Customer customer2 = new Customer("Gamaz","Zamaz",19,"0501110099","GAMAZ@gmail.com");
//
//        OrderCart orderCart = new OrderCart();
//        OrderCart orderCart1 = new OrderCart();
//
//        Product product = new Product("Phone mi1","Best phone",12500);
//        Product product1 = new Product("Pen smart pen2000", "Best smart pen",5000);
//        Product product2 = new Product("Phone Iphone","Iphon is iphon",300000);
//        Product product3 = new Product("Laptop HP","cheap laptop",11000);
//        Product product4 = new Product("Watch smart watch","Best smart watch",9000);
//
//        productService.save(product);
//        productService.save(product1);
//        productService.save(product2);
//        productService.save(product3);
//        productService.save(product4);
//
//        customerService.save(customer);
//        customerService.save(customer1);
//        customerService.save(customer2);
//
//        ArrayList listProduct  = new ArrayList();
//        listProduct.add(product);
//        listProduct.add(product1);
//        listProduct.add(product3);
//
//        orderCart.setProductList(listProduct);
//        orderCart.setCustomerID(customer);
//
//        List<OrderCart> order = new ArrayList<>();
//        order.add(orderCart);
//        customer.setOrderCart(order);
//
//        orderCartService.save(orderCart);
//
//        ArrayList listProduct1  = new ArrayList();
//        listProduct.add(product1);
//        listProduct.add(product1);
//        listProduct.add(product4);
//
//        orderCart.setProductList(listProduct1);
//        orderCart.setCustomerID(customer2);
//
//        List<OrderCart> order1 = new ArrayList<>();
//        order.add(orderCart1);
//        customer.setOrderCart(order1);
//
//        orderCartService.save(orderCart1);
//    }
//}
