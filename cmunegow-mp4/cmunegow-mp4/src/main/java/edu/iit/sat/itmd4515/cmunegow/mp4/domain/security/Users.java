package edu.iit.sat.itmd4515.cmunegow.mp4.domain.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author Chetan Munegowda
 */
@Entity
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
public class Users implements Serializable{

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    private String userName;
    private String userPassword;
    private Boolean enabled;
    
    @ManyToMany
    @JoinTable(
            name = "shop_users_groups",
            joinColumns = @JoinColumn(name = "userName"),
            inverseJoinColumns = @JoinColumn(name = "groupName"))
    private List<Groups> groups = new ArrayList<>();

    /**
     * Default Constructor
     */
    public Users() {
    }

    /**
     * Parameterized Constructor
     * @param userName
     * @param userPassword
     */
    public Users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    /**
     *
     * @param g
     */
    
    
    public void addGroups(Groups g){
        if(!groups.contains(g)){
            groups.add(g);
        }
       
        if(g.getUsers().contains(this)){
            g.getUsers().add(this);
        }
    }

    /**
     *
     * @return
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * @return
     */
    public List<Groups> getGroups() {
        return groups;
    }

    /**
     *
     * @param groups
     */
    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
    
    /**
     *
     * @return
     */
        public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    /**
     *
     */
    @PrePersist
    @PreUpdate
    public void setPassword(){
         String digestPassword = DigestUtils.md5Hex(userPassword);
         this.userPassword = digestPassword;
    }

}
