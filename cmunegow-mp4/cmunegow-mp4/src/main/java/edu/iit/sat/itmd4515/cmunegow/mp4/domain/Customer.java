package edu.iit.sat.itmd4515.cmunegow.mp4.domain;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.security.Users;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User can be Customer who uses the Online Portal System
 *
 * @author Chetan Munegowda
 */
@Entity
@Table(name = "Customers")
@NamedQueries({
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.custName = :custname"),
    @NamedQuery(name= "Customer.findById", query= "SELECT c FROM Customer c WHERE c.custId = :custId"),
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name= "Customer.findByUserName", query = "SELECT c FROM Customer c WHERE c.user.userName = :userName")
})

public class Customer implements Serializable{

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String custId;
    
    @Column(nullable = false, unique = true, length= 40)
    private String custName;
    
    @Column(nullable = false, unique = true, length = 20)
    private String custPhone;
    
    @Column(nullable = false, unique = true, length = 45)
    private String custEmail;
    
    @Column
    private Integer custAge;
    
    @Column(unique = true, length = 20)
    private String cardNumber;
    
    @OneToOne
    @JoinColumn(name = "USERNAME", unique = true, nullable = false)
    private Users user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTADDRESSID", unique = true, nullable = false)
    private CustomerAddress custAddress;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTID")
    private List<Orders> order;
    

    // ======================================
    // =            Constructors            =
    // ======================================

   
    /**
     *Default constructor for
     * Customer
     */
        public Customer() {
    }

    /**
     * This Constructor initializes the customer fields
     * @param userPassword
     * @param custName
     * @param custPhone
     * @param custEmail
     * @param custAge
     * @param cardNumber
     */
    public Customer(String custName, String custPhone, String custEmail, Integer custAge, String cardNumber) {
        this.custName = custName;
        this.custPhone = custPhone;
        this.custEmail = custEmail;
        this.custAge = custAge;
        this.cardNumber = cardNumber;
    }
    
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    /**
     * Getter method to return customer age
     * @return
     */
        public Integer getCustAge() {
        return custAge;
    }

    /**
     *  Sets the Customer Age
     * @param custAge
     */
    public void setCustAge(Integer custAge) {
        this.custAge = custAge;
    }

    /**
     * Getter method which returns customer Email
     * @return
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     *
     * @param custEmail
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    /**
     * Get method for Customer Phone
     * @return custPhone
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * Setter for custPhone
     * @param custPhone
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    /**
     * Getter method for the Customer Name
     * @return custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * Getter for Customer Address
     * @return custAddress
     */
    public CustomerAddress getCustAddress() {
        return custAddress;
    }

    /**
     * Setter for Customer Address
     * @param custAddress
     */
    public void setCustAddress(CustomerAddress custAddress) {
        this.custAddress = custAddress;
    }
    
    /**
     *  Setter for the Customer name
     * @param custName
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * Return the card number   
     * @return
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     *
     * @param cardNumber
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     *
     * @return
     */
    public List<Orders> getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    public void setOrder(List<Orders> order) {
        this.order = order;
    }

    /**
     *
     * @return
     */
    public Users getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(Users user) {
        this.user = user;
    }
    
    
    

    @Override
    public String toString() {
        return "Customer{" + "custName=" + custName + ", custPhone=" + custPhone + ", custEmail=" + custEmail + ", custAge=" + custAge + ", cardNumber=" + cardNumber + ", custAddress=" + custAddress + '}';
    }
    
    
    
}
