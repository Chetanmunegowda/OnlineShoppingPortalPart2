/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Items;
import java.util.List;
import javax.ejb.Stateless;

/**
 * EJB Stateless bean which implements the business 
 * methods for the Item Service
 * @author Chetan Munegowda
 */

@Stateless
public class ItemService extends AbstractService<Items>{

    /**
     *
     */
    public ItemService() {
        super(Items.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Items> findAll() {
        return getEntityManager().createNamedQuery("Items.findAll", Items.class).getResultList();
    }
    
    /**
     *
     * @param itemId
     * @return
     */
    public Items findItemById(Long itemId) {
        return getEntityManager().createNamedQuery("Items.findById",Items.class).setParameter("ItemId", itemId).getSingleResult();
    }

    
}
