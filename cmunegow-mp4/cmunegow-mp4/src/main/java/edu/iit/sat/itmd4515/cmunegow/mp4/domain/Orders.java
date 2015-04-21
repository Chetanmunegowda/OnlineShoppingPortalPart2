package edu.iit.sat.itmd4515.cmunegow.mp4.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ***************************
 * Customer can place one to many orders. Orders contains the Order Amount,
 * Order Status etc **************************
 */
@Entity
@Table(name = "Orders")
@NamedQueries({
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
})
public class Orders implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column(nullable = false)
    private String ordStatus;

    @Column(nullable = false)
    private Integer ordTotAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date ordCreationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date ordCancelDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date ordDeliverDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDERID")
    private List<OrderItems> ordItems;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PAYMENTID", unique = true, nullable = false)
    private Payment pymt;

    // ======================================
    // =            Constructors            =
    // ======================================

    /**
     *
     */
        public Orders() {
    }

    /**
     *
     * @param ordStatus
     * @param ordTotAmount
     * @param ordCreationDate
     */
    public Orders(String ordStatus, Integer ordTotAmount, Date ordCreationDate) {
        this.ordStatus = ordStatus;
        this.ordTotAmount = ordTotAmount;
        this.ordCreationDate = ordCreationDate;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    /**
     *
     * @return
     */
        public Long getOrderId() {
        return orderId;
    }

    /**
     *
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     *
     * @return
     */
    public Date getOrdCreationDate() {
        return ordCreationDate;
    }

    /**
     *
     * @param ordCreationDate
     */
    public void setOrdCreationDate(Date ordCreationDate) {
        this.ordCreationDate = ordCreationDate;
    }

    /**
     *
     * @return
     */
    public String getOrdStatus() {
        return ordStatus;
    }

    /**
     *
     * @param ordStatus
     */
    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    /**
     *
     * @return
     */
    public Integer getOrdTotAmount() {
        return ordTotAmount;
    }

    /**
     *
     * @param ordTotAmount
     */
    public void setOrdTotAmount(Integer ordTotAmount) {
        this.ordTotAmount = ordTotAmount;
    }

    /**
     *
     * @param oiList
     * @param item
     * @return
     */
    public Integer calculateOrderTotCost(List<OrderItems> oiList, Items item) {
        Integer orderCost = 0;

        return orderCost;
    }

    /**
     *
     * @return
     */
    public Payment getPymt() {
        return pymt;
    }

    /**
     *
     * @param pymt
     */
    public void setPymt(Payment pymt) {
        this.pymt = pymt;
    }

    /**
     *
     * @return
     */
    public List<OrderItems> getOrdItems() {
        return ordItems;
    }

    /**
     *
     * @param ordItems
     */
    public void setOrdItems(List<OrderItems> ordItems) {
        this.ordItems = ordItems;
    }

    /**
     *
     * @return
     */
    public Date getOrdCancelDate() {
        return ordCancelDate;
    }

    /**
     *
     * @param ordCancelDate
     */
    public void setOrdCancelDate(Date ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    /**
     *
     * @return
     */
    public Date getOrdDeliverDate() {
        return ordDeliverDate;
    }

    /**
     *
     * @param ordDeliverDate
     */
    public void setOrdDeliverDate(Date ordDeliverDate) {
        this.ordDeliverDate = ordDeliverDate;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", ordStatus=" + ordStatus + ", ordTotAmount=" + ordTotAmount + ", ordCreationDate=" + ordCreationDate + ", ordCancelDate=" + ordCancelDate + ", ordDeliverDate=" + ordDeliverDate + '}';
    }
    
    

}
