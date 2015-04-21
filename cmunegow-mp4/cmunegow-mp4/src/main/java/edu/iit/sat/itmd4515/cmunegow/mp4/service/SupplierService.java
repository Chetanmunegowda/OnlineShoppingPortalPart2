/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Supplier;
import java.util.List;
import javax.ejb.Stateless;

/**
 * EJB Stateless bean which implements the business methods 
 * for Supplier Service
 * @author Chetan Munegowda
 */
@Stateless
public class SupplierService extends AbstractService<Supplier>{

    /**
     *
     */
    public SupplierService() {
        super(Supplier.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Supplier> findAll() {   
        return getEntityManager().createNamedQuery("Shipper.findAll").getResultList();
    }
    
    /**
     *
     * @param strUserName
     * @return
     */
    public Supplier findByUserName(String strUserName){
        return getEntityManager().createNamedQuery("Supplier.findByUserName",Supplier.class).setParameter("userName", strUserName).getSingleResult();
    }
}
