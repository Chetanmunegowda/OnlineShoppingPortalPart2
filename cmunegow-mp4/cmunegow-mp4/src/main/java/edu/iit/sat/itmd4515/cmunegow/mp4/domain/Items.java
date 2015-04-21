package edu.iit.sat.itmd4515.cmunegow.mp4.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * ********************************
 * Suppler supplies many Items. Its many to many relationship
 * *******************************
 */
@Entity
@Table(name = "Items")
@NamedQueries({
    @NamedQuery(name = "Items.findById", query = "SELECT i FROM Items i WHERE i.itemId = :ItemId"),
    @NamedQuery(name = "Items.findByName", query = "SELECT i FROM Items i WHERE i.itemName = :ItemName"),
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i")
})
public class Items implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(nullable = false, length = 30, unique = true)
    private String itemName;
    @Column(nullable = false)
    private Integer itemCost;
    @Column(nullable = false)
    private Integer itemQuantity;
    @Column(nullable = false)
    private Boolean itemAvailability;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
     @JoinTable(name = "Item_Category",
               joinColumns = 
                       @JoinColumn(name = "itemId", referencedColumnName = "itemId"),
               inverseJoinColumns = 
                       @JoinColumn(name = "catId", referencedColumnName = "catId"))
    private Category category;
   

    @ManyToMany(mappedBy = "supItems")
    private List<Supplier> itmSuppliers;
    

    // ======================================
    // =            Constructors            =
    // ======================================

    /**
     *
     */
        public Items() {
    }

    /**
     *
     * @param itemName
     * @param itemCost
     * @param itemQuantity
     * @param itemAvailability
     */
    public Items(String itemName, Integer itemCost, Integer itemQuantity, Boolean itemAvailability) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemQuantity = itemQuantity;
        this.itemAvailability = itemAvailability;
    }
    
    
    

     // ======================================
    // =          Getters & Setters         =
    // ======================================

    /**
     *
     * @return
     */
    
    public Long getItemId() {
        return itemId;
    }

    /**
     *
     * @param itemId
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     *
     * @return
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return
     */
    public Integer getItemCost() {
        return itemCost;
    }

    /**
     *
     * @param itemCost
     */
    public void setItemCost(Integer itemCost) {
        this.itemCost = itemCost;
    }

    /**
     *
     * @return
     */
    public Integer getItemQuantity() {
        return itemQuantity;
    }

    /**
     *
     * @param itemQuantity
     */
    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     *
     * @return
     */
    public Boolean getItemAvailability() {
        return itemAvailability;
    }

    /**
     *
     * @param itemAvailability
     */
    public void setItemAvailability(Boolean itemAvailability) {
        this.itemAvailability = itemAvailability;
    }

    /**
     *
     * @return
     */
    public List<Supplier> getItmSuppliers() {
        return itmSuppliers;
    }

    /**
     *
     * @param itmSuppliers
     */
    public void setItmSuppliers(List<Supplier> itmSuppliers) {
        this.itmSuppliers = itmSuppliers;
    }
    
    

    @Override
    public String toString() {
        return "Items{" + "itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + ", itemQuantity=" + itemQuantity + ", itemAvailability=" + itemAvailability + '}';
    }
    
    
}
