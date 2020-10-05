import Models.Customer;
import Models.OrderCart;
import Models.Product;

import Services.*;

public class Main {
    public static void main(String[] args) throws Exception {

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();

        OrderCart orderCart = new OrderCart();
        OrderCart orderCart1 = new OrderCart();
        OrderCart orderCart2 = new OrderCart();

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

        orderCart.addProduct(mi);
        orderCart.setCustomerID(customer);
        System.out.println(orderCart);

        orderCart1.addProduct(mi);
        orderCart1.addProduct(mi1);
        orderCart1.addProduct(mi2);
        orderCart1.setCustomerID(customer1);
        System.out.println(orderCart1);

        orderCart2.addProduct(mi1);
        orderCart2.addProduct(mi2);
        orderCart2.setCustomerID(customer2);
        System.out.println(orderCart2);
    }
}
