/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * EJB Stateless bean which implements the business methods 
 * for Order Service
 * @author Chetan Munegowda
 */
@Stateless
public class OrderService extends AbstractService<Orders>{

    /**
     * Default constructor for Order Service
     */
    public OrderService(){
        super(Orders.class);
    }
    
    /**
     * Lists all the orders
     * @return
     */
    @Override
    public List<Orders> findAll() {
        return getEntityManager().createNamedQuery("Orders.findAll", Orders.class).getResultList();
    }
    
    /**
     * Method to find the Orders using customer name
     * @param strName
     * @return
     */
    public Orders findOrdersByCustomerName(String strName){
        
        TypedQuery<Orders> query =  getEntityManager().createQuery(
                "Select o from Orders o, Customer c WHERE c.order.orderId = o.orderId and c.custName = ?1", 
                Orders.class);
        
        Orders ord = query.setParameter(1, strName).getSingleResult();
        return ord;
    }
    
    
    
}
