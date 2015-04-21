/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.security.Users;
import java.util.List;
import javax.ejb.Stateless;

/**
 * EJB Stateless bean which implements the business methods 
 * for User Service
 * @author Chetan Munegowda
 */
@Stateless
public class UserService extends AbstractService<Users>{

    /**
     * Default Constructor for User Service
     */
    public UserService() {
        super(Users.class);
    }
 
    /**
     * Lists all the Users
     * @return 
     */
    @Override
    public List<Users> findAll() {
        return getEntityManager().createNamedQuery("Users.findAll").getResultList();
    }
    
}
