package Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.ArrayList;
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
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "customer_id")
    private Customer customerID;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name ="Product_Order",
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

    public List<Product> getProductList (List listProduct) {
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
