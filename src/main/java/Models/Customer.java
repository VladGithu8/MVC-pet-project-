package Models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="Customer")
public class Customer  {

    public Customer() {}

    @OneToMany(targetEntity = OrderCart.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderCart> orderCartList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
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
        orderCartList = new LinkedList<OrderCart>();
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

    public List<OrderCart> setOrderCart(List<OrderCart> orderCartList){
        this.orderCartList = orderCartList;
        return orderCartList;
    }

    public List<OrderCart> getOrderCart(List<OrderCart> orderCartList){
        if(orderCartList == null){
            return new ArrayList<OrderCart>();
        }else{
            return orderCartList;
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
