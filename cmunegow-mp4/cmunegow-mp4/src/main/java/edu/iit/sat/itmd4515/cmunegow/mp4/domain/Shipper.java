package edu.iit.sat.itmd4515.cmunegow.mp4.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Shipper ships the Items. This is mapped with many suppliers
 * @author Chetan Munegowda
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Shipper.findById",query = "select s from Shipper s where s.shipId = :shipId"),
    @NamedQuery(name = "Shipper.findByName",query = "select s from Shipper s where s.shipName = :sName"),
    @NamedQuery(name = "Shipper.findAll",query = "select s from Shipper s")
})
public class Shipper implements Serializable{

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipId;
    @Column(unique = true, nullable = false, length = 50)
    private String shipName;
    @Column(unique = true, nullable = false)
    private String shipPhone;

    @ManyToMany(mappedBy = "shippers", cascade = CascadeType.PERSIST)
    private List<Supplier> suppliers;

    // ======================================
    // =            Constructors            =
    // ======================================

    /**
     *
     */
        public Shipper() {
    }

    /**
     *
     * @param shipName
     * @param shipPhone
     */
    public Shipper(String shipName, String shipPhone) {
        this.shipName = shipName;
        this.shipPhone = shipPhone;
    }

    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    /**
     *
     * @return
     */
    
    public Long getShipId() {
        return shipId;
    }

    /**
     *
     * @param shipId
     */
    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    /**
     *
     * @return
     */
    public String getShipName() {
        return shipName;
    }

    /**
     *
     * @param shipName
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    /**
     *
     * @return
     */
    public String getShipPhone() {
        return shipPhone;
    }

    /**
     *
     * @param shipPhone
     */
    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    /**
     *
     * @return
     */
    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     *
     * @param suppliers
     */
    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public String toString() {
        return "Shipper{" + "shipId=" + shipId + ", shipName=" + shipName + ", shipPhone=" + shipPhone + '}';
    }
    
    
    
}
