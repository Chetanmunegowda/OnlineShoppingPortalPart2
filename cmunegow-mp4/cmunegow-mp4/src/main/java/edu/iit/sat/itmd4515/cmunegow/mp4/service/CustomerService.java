/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Customer;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * EJP Stateless bean which implements business methods for Customer 
 * Service
 * @author Chetan Munegowda
 */
@Stateless
public class CustomerService extends AbstractService<Customer>{

    /**
     *
     */
    public CustomerService() {
        super(Customer.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Customer> findAll() {
       return getEntityManager().createNamedQuery("Customer.findAll").getResultList();
    }
    
    /**
     *
     * @param custName
     * @return
     */
    public Customer findByCustomerName(String custName){
        return getEntityManager().createNamedQuery("Customer.findByName", Customer.class).setParameter("custname", custName).getSingleResult();
    }
    
    /**
     *
     * @param strUserName
     * @return
     */
    public Customer findByUserName(String strUserName){
        return getEntityManager().createNamedQuery("Customer.findByUserName", Customer.class).setParameter("userName", strUserName).getSingleResult();
    }
        
}
