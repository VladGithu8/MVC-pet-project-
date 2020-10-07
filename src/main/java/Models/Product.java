package Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="Product")
public class Product implements Serializable {

    public Product() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany
    @JoinTable(name = "Product_OrderCart",
            joinColumns = @JoinColumn(name = "Product_id"),
            inverseJoinColumns = @JoinColumn(name = "OrderCart_id"))
    private List<OrderCart> orderCart;

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
        return orderCart;
    }

    public void setOrderCart(List<OrderCart> orderCart) {
        this.orderCart = orderCart;
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


