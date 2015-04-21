/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.domain.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author Chetan Munegowda
 */
@Entity
@NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g")
public class Groups implements Serializable{
    
    @Id
    private String groupName;
    private String groupDesc;
    
    @ManyToMany(mappedBy = "groups")
    private List<Users> users = new ArrayList<>();

    /**
     *
     */
    public Groups() {
    }

    /**
     *
     * @param groupName
     * @param groupDesc
     */
    public Groups(String groupName, String groupDesc) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }
    
    /**
     *
     * @param u
     */
    public void addUsers(Users u){
        if(!users.contains(u)){
            users.add(u);
        }
        
        if(u.getGroups().contains(this)){
            u.getGroups().add(this);
        }
    }

    /**
     *
     * @return
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     *
     * @return
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     *
     * @param groupDesc
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     *
     * @return
     */
    public List<Users> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<Users> users) {
        this.users = users;
    }
    
    
    
}
