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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User can be Supplier. Supplier can supply many items and has many shippers
 *
 * @author Chetan Munegowda
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findById", query = "SELECT s FROM Supplier s WHERE s.supId = :supId"),
    @NamedQuery(name = "Supplier.findByUserName", query = "SELECT s FROM Supplier s WHERE s.user.userName = :userName")
})
@Table(name = "Suppliers")
public class Supplier implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String supId;

    @Column(nullable = false, unique = true, length = 20)
    private String supPhone;
    @Column(nullable = false, unique = true, length = 45)
    private String supEmail;

    @OneToOne
    @JoinColumn(name = "USERNAME", nullable = false, unique = true)
    private Users user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SUPADDRID", unique = true, nullable = false)
    private SupplierAddress supAddress;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Suplr_Items", joinColumns = @JoinColumn(name = "supId"), inverseJoinColumns = @JoinColumn(name = "itemId"))
    private List<Items> supItems;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Suplr_Shipper", joinColumns = @JoinColumn(name = "supId"), inverseJoinColumns = @JoinColumn(name = "shipperId"))
    private List<Shipper> shippers;

    // ======================================
    // =            Constructors            =
    // ======================================
    /**
     *
     */
    public Supplier() {
    }

    /**
     *
     * @param supPhone
     * @param supEmail
     */
    public Supplier(String supPhone, String supEmail) {
        this.supPhone = supPhone;
        this.supEmail = supEmail;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================
    /**
     *
     * @return
     */
    public String getSupPhone() {
        return supPhone;
    }

    /**
     *
     * @param supPhone
     */
    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    /**
     *
     * @return
     */
    public SupplierAddress getSupAddress() {
        return supAddress;
    }

    /**
     *
     * @param supAddress
     */
    public void setSupAddress(SupplierAddress supAddress) {
        this.supAddress = supAddress;
    }

    /**
     *
     * @return
     */
    public List<Items> getSupItems() {
        return supItems;
    }

    /**
     *
     * @param supItems
     */
    public void setSupItems(List<Items> supItems) {
        this.supItems = supItems;
    }

    /**
     *
     * @return
     */
    public List<Shipper> getShippers() {
        return shippers;
    }

    /**
     *
     * @param shippers
     */
    public void setShippers(List<Shipper> shippers) {
        this.shippers = shippers;
    }

    /**
     *
     * @return
     */
    public String getSupEmail() {
        return supEmail;
    }

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
    
    
    

    /**
     *
     * @param supEmail
     */
    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supPhone=" + supPhone + ", supEmail=" + supEmail + '}';
    }

}
