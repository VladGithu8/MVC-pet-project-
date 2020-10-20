package Models;

import Models.OrderCart;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.GenerationType;
import javax.persistence.FetchType;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Product_OrderCart",
            joinColumns = @JoinColumn(name = "Product_id"),
            inverseJoinColumns = @JoinColumn(name = "OrderCart_id"))
    private List<OrderCart> orderCartList;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    public Product(String productName, String description, double price) {
        this.description = description;
        this.price = price;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderCart> getOrderCart() {
        if (orderCartList == null) {
            return new ArrayList<OrderCart>();
        } else {
            return orderCartList;
        }
    }

    public List<OrderCart> setOrderCart(List<OrderCart> orderCartList) {
        this.orderCartList = orderCartList;
        return orderCartList;
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
