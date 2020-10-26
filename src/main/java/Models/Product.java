package Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="Product")
public class Product implements Serializable {

    public Product() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(mappedBy = "productList" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orderList;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    public Product(int id, String productName, String description, double price, List<Order> orderList) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.productName = productName;
        this.orderList = orderList;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOrder() {
        if (orderList == null) {
            return new ArrayList<Order>();
        } else {
            return orderList;
        }
    }

    public List<Order> setOrder(List<Order> orderList) {
        this.orderList = orderList;
        return orderList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

