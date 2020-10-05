package Models;

import Models.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name ="OrderCart")
public class OrderCart {

    public OrderCart() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerID;

    @ManyToMany
    @JoinTable(name ="Product_OrderCart",
            joinColumns = @JoinColumn(name ="OrderCart_id"),
            inverseJoinColumns = @JoinColumn(name= "Product_id"))
    private List<Product> productList;

    public void addProduct(Product product){
       productList.add(product);
    }

    public OrderCart(int id) {
        this.id = id;
        productList = new LinkedList<Product>();
    }

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}



