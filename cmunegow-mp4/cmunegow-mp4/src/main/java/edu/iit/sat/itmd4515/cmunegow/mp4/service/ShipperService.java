/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Shipper;
import java.util.List;
import javax.ejb.Stateless;

/**
 * EJB Stateless bean which implements the business methods 
 * for Shipper Service
 * @author Chetan Munegowda
 */
@Stateless
public class ShipperService extends AbstractService<Shipper>{

    /**
     * Default constructor for shipper service
     */
    public ShipperService() {
        super(Shipper.class);
    }    
    
    /**
     * Lists all the Shippers
     * @return
     */
    @Override
    public List<Shipper> findAll() {
       return  getEntityManager().createNamedQuery("Shipper.findAll").getResultList();
    }
    
    
    
    
}
