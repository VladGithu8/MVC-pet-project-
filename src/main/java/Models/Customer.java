package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Customer",
        uniqueConstraints = {@UniqueConstraint
                (columnNames = {"phone","e_mail"})})
public class Customer  {

    public Customer() {}

    @OneToMany(mappedBy = "customer",
            targetEntity = Order.class,
            fetch = FetchType.LAZY,
            cascade = javax.persistence.CascadeType.ALL)
    private List<Order> orderList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id", unique = true, nullable = false)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="phone")
    private String phone;

    @Column(name="e_mail")
    private String email;

    public Customer(int id, String firstName, String lastName, int age, String phone, String email, List<Order> orderList){
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.phone = phone;
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> setOrder(List<Order> orderList) {
        this.orderList = orderList;
        return orderList;
    }

    public List<Order> getOrder(List<Order> orderList){
        if(orderList == null){
            return new ArrayList<Order>();
        }else{
            return orderList;
        }
    }

    @Override
    public String toString(){
        return "Models.Customer{"+
                "id = "+id+
                "firstName = "+firstName+
                "lastName = "+lastName+
                "age = "+age+
                "phone = "+phone+
                "email="+email+'}';
    }
}

