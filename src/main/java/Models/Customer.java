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

    public Customer(String firstName, String lastName, int age, String phone, String email){
        this.age = age;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.phone = phone;
    }

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

    public Customer setId(int id) {
        this.id = id;
        return Customer.this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return Customer.this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return Customer.this;
    }

    public int getAge() {
        return age;
    }

    public Customer setAge(int age){
        this.age = age;
        return Customer.this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return Customer.this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return Customer.this;
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

