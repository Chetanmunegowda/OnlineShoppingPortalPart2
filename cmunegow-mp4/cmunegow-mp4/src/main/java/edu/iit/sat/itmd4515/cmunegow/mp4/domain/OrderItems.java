package edu.iit.sat.itmd4515.cmunegow.mp4.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * ***************************************
 * Order Items contains ItemId,Item Quantity and its cost
 * *****************************************
 */
@Entity
@Table(name = "OrderItems")
@IdClass(OrderItemId.class)
@NamedQueries({
    @NamedQuery(name = "OrderItems.findAll", query = "SELECT oi FROM OrderItems oi")
})
public class OrderItems implements Serializable {

    // ======================================
    // =             Attributes             =
    // ====================================== 
    @Id
    private Long itemId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;
   
    private Integer ordItemQuantity;
    
    private Integer ordItemCost;
    

    // ======================================
    // =            Constructors            =
    // ======================================

    /**
     *
     */
        public OrderItems() {
    }

    /**
     *
     * @param itemId
     * @param ordItemQuantity
     * @param ordItemCost
     */
    public OrderItems(Long itemId, Integer ordItemQuantity, Integer ordItemCost) {
        this.itemId = itemId;
        this.ordItemQuantity = ordItemQuantity;
        this.ordItemCost = ordItemCost;
    }
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================
   
    /**
     *
     * @return
     */
       
    public Integer getOrdItemQuantity() {
        return ordItemQuantity;
    }

    /**
     *
     * @param ordItemQuantity
     */
    public void setOrdItemQuantity(Integer ordItemQuantity) {
        this.ordItemQuantity = ordItemQuantity;
    }

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
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     *
     * @param orderItemId
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     *
     * @return
     */
    public Integer getOrdItemCost() {
        return ordItemCost;
    }

    /**
     *
     * @param ordItemCost
     */
    public void setOrdItemCost(Integer ordItemCost) {
        this.ordItemCost = ordItemCost;
    }

    @Override
    public String toString() {
        return "OrderItems{" + "itemId=" + itemId + ", orderItemId=" + orderItemId + ", ordItemQuantity=" + ordItemQuantity + ", ordItemCost=" + ordItemCost + '}';
    }
    
    
   
}
