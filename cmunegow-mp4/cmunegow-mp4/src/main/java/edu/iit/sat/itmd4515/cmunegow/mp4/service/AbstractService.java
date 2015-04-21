/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstract class which which implements the CRUD 
 * operations for the Generic Entity passed
 * @author Chetan Munegowda
 * @param <T>
 */
public abstract class AbstractService<T> {
    
    @PersistenceContext(unitName = "cmunegowPU")
    private EntityManager em;
    
    private final Class<T> entityClass;
    
    /**
     *
     * @param entityClass
     */
    protected AbstractService(Class entityClass){
        this.entityClass = entityClass;
    }
    
    /**
     * Returns the Entity Manager
     * @return
     */
    protected EntityManager getEntityManager(){
        return this.em;
    }
    
    /**
     * Create the Entity
     * @param entity
     */
    public void createEntity(T entity){
        em.persist(entity);
    }
    
    /**
     * Update the entity
     * @param entity
     */
    public void updateEntity(T entity){
        em.merge(entity);
    }
    
    /**
     * Find the entity using id
     * @param id
     * @return
     */
    public T find(Object id){
        return em.find(entityClass, id);
    }
    
    /**
     *
     * @return
     */
    public abstract List<T> findAll();
    
    /**
     * Removes the entity
     * @param entity
     */
    public void deleteEntity(T entity){
        em.remove(em.merge(entity));
    }
    
    /**
     * Removes the Entity using the Entity's Id
     * @param id
     */
    public void deleteById(Object id){
        em.remove(em.find(entityClass, id));
    }
    
    
    
    
}
