package edu.iit.sat.itmd4515.cmunegow.mp4.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Customer Address contains the address fields of customer
 * @author Chetan Munegowda
 */
@Entity
@NamedQuery(name = "CustomerAddress.findById", query = "SELECT ca FROM CustomerAddress ca WHERE ca.custAddressId = :custAddrId")
@Table(name = "CustomerAddress")
public class CustomerAddress implements Serializable{

    // ======================================
    // =             Attributes             =
    // =====================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long custAddressId;

    @Column(name = "custAddrStreet1", nullable = false)
    private String Street1;
    @Column(name = "custAddrStreet2")
    private String street2;
    @Column(name = "custAddrCity", nullable = false)
    private String city;
    @Column(name = "custAddrState", nullable = false)
    private String state;
    @Column(name = "custAddrZipCode", nullable = false)
    private String zipcode;
    @Column(name = "custAddrCountry", nullable = false)
    private String country;

     // ======================================
    // =            Constructors            =
    // ======================================

    /**
     *
     */
    
    public CustomerAddress() {
    }

    /**
     *
     * @param Street1
     * @param street2
     * @param city
     * @param state
     * @param zipcode
     * @param country
     */
    public CustomerAddress(String Street1, String street2, String city, String state, String zipcode, String country) {
        this.Street1 = Street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    /**
     *
     * @return
     */
        public Long getCustAddressId() {
        return custAddressId;
    }

    /**
     *
     * @param custAddressId
     */
    public void setCustAddressId(Long custAddressId) {
        this.custAddressId = custAddressId;
    }

    /**
     *
     * @return
     */
    public String getStreet1() {
        return Street1;
    }

    /**
     *
     * @param Street1
     */
    public void setStreet1(String Street1) {
        this.Street1 = Street1;
    }

    /**
     *
     * @return
     */
    public String getStreet2() {
        return street2;
    }

    /**
     *
     * @param street2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     *
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" + "custAddressId=" + custAddressId + ", Street1=" + Street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + '}';
    }
    
    

}
