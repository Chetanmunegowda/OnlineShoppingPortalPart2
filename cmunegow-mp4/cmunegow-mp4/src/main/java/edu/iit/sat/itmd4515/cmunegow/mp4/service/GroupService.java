/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.security.Groups;
import java.util.List;
import javax.ejb.Stateless;

/**
 * EJB Stateless bean which implements the business methods for
 * Group Service
 * @author Chetan Munegowda
 */
@Stateless
public class GroupService extends AbstractService<Groups>{

    /**
     *
     */
    public GroupService(){
        super(Groups.class);
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Groups> findAll() {
        return getEntityManager().createNamedQuery("Groups.findAll").getResultList();
    }
      
}
