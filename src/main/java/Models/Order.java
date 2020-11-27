package Models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Orders")
public class Order {

    public Order() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Customer customer;

    @ManyToMany
    @JoinTable(name ="Order_Products",
            joinColumns = @JoinColumn(name ="Order_id"),
            inverseJoinColumns = @JoinColumn(name= "Product_id"))
    private List<Product> productList;

    public Order(int id, Customer customer, List<Product> productList) {
        this.id = id;
        this.productList = productList;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return Order.this;
    }

    public Customer getCustomer(Customer customer) {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return Order.this;
    }

    public List<Product> getProductList (List<Product> productList) {
        if (productList == null) {
            return new ArrayList<Product>();
        } else {
            return productList;
        }
    }

    public List<Product> setProductList(List<Product> productList) {
        this.productList = productList;
        return productList;
    }
}

