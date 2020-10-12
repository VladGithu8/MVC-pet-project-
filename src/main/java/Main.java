import Models.Customer;
import Models.OrderCart;
import Models.Product;

import Services.CustomerService;
import Services.ProductService;
import Services.OrderCartService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderCartService orderCartService = new OrderCartService();

        List<Product> products = new ArrayList<>();
        List<Product> products1 = new ArrayList<>();
        List<Product> products2 = new ArrayList<>();

        Customer customer = new Customer("Evgen","Borovoi",25,"0932223344","BorEv@gmail.com");
        Customer customer1 = new Customer("Semen","Korobkin",34,"0603335566","SemenKorobkin@gmail.com");
        Customer customer2 = new Customer("Gamaz","Zamaz",19,"0501110099","GAMAZ@gmail.com");
        customerService.saveCustomer(customer);
        customerService.saveCustomer(customer1);
        customerService.saveCustomer(customer2);

        Product mi = new Product("Xiaomy","Super phone",12900);
        Product mi1 = new Product("12Xiaomy","11Super phone",16800);
        Product mi2 = new Product("999Xiaomy","22Super phone",20200);
        productService.saveProduct(mi);
        productService.saveProduct(mi1);
        productService.saveProduct(mi2);

        System.out.println(productService.findAllProducts());
        System.out.println(productService.findAllProductsToString());

        System.out.println(customerService.findAllCustomers());
        System.out.println(customerService.findAllCustomersToString());
    }
}
