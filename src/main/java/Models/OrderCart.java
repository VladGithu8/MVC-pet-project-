package Models;

import javax.persistence.*;
import java.util.List;

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

    public OrderCart(Customer customerID,List<Product> productList) {
        this.productList = productList;
        this.customerID = customerID;
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
        return productList;}

    public void setProductList(List<Product> productList) {
        this.productList = productList;}
}



