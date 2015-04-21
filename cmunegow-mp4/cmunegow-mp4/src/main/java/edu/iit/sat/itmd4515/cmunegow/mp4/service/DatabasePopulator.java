/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cmunegow.mp4.service;

import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Category;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Customer;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.CustomerAddress;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Items;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.OrderItems;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Orders;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Payment;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Shipper;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.Supplier;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.SupplierAddress;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.security.Groups;
import edu.iit.sat.itmd4515.cmunegow.mp4.domain.security.Users;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Chetan Munegowda
 */
@Singleton
@Startup
public class DatabasePopulator {
    
    @EJB
    private CustomerService customerService;

    @EJB
    private GroupService groupService;

    @EJB
    private SupplierService supplierService;

    @EJB
    private UserService userService;

    @EJB
    private ShipperService shipperService;
    
    @EJB
    private OrderService orderService;

    /**
     *
     */
    public DatabasePopulator() {
    }
    
    /**
     * This methods populates the database using the business methods 
     * of the Stateless EJB bean services
     */
    @PostConstruct
    private void seedDatabase(){
        
        Groups custGroup = new Groups("CUSTOMER", "Customers who uses our shopping portal to buy items");
        Groups supGroup =  new Groups("SUPPLIER", "Supplier who manages our shopping portal");
        
        Users user1 = new Users("chetanmunegowda", "1234abc");
        Users sup1 = new Users("flipkart", "ghj789");
        Users user3 = new Users("pranjalmalav", "ioy908");
        Users sup2 = new Users("wallmart", "sxj345");
        user1.addGroups(custGroup);
        sup1.addGroups(supGroup);
        user3.addGroups(custGroup);
        sup2.addGroups(supGroup);
        
        SupplierAddress supAddr = new SupplierAddress("3440 S. Cottage Gove Avenue", null, "Chicago", "Illinois", "60613", "United States");

        Shipper ship1 = new Shipper("Flipkart Courier", "3124568789");
        Shipper ship2 = new Shipper("Kaage Courier", "3124569789");
        
        Category  cat1 = new Category("Stationary Items");
        Items i1 = new Items("Notebook", 2, 100, Boolean.TRUE);
        Items i2 = new Items("Pen", 2, 200, Boolean.TRUE);
       
        
        List<Shipper> shipperList = new ArrayList<>();
        List<Items> itemList = new ArrayList<>();
        shipperList.add(ship1);
        shipperList.add(ship2);
        
        itemList.add(i1);
        itemList.add(i2);
        
        cat1.setItems(itemList);
        
        Supplier supplier = new Supplier("3124780877", "flipkart@org.com");
        supplier.setUser(sup1);
        supplier.setShippers(shipperList);
        supplier.setSupAddress(supAddr);
        supplier.setSupItems(itemList);

        if(supplier !=null){
            System.out.println(supplier.getSupEmail());
            
            for(Shipper ship: supplier.getShippers()){
                System.out.println(ship.getShipName());
            }
            
            //System.out.println(supplier.getUser().getUserName());
        }
        
        
        groupService.createEntity(custGroup);
        groupService.createEntity(supGroup);
        
        userService.createEntity(user1);
        userService.createEntity(user3);
        userService.createEntity(sup1);
        userService.createEntity(sup2);
       
        
        supplierService.createEntity(supplier);
        
        List<OrderItems> ordrItemList = new ArrayList<>();
        
        OrderItems ordItm1 = new OrderItems(i1.getItemId(),10,i1.getItemCost());
        OrderItems ordItm2 = new OrderItems(i2.getItemId(),10, i2.getItemCost());
        
        ordrItemList.add(ordItm1);
        ordrItemList.add(ordItm2);
        
        CustomerAddress custAdrObj = new CustomerAddress("3420 S Cottage Grove Avenue", null, "Chicago", "Illinois", "60616", "United States");
        Customer custObj = new Customer("Chetan", "123412311", "chetu@gmail.com", 30,"4567567809874567");
        custObj.setCustAddress(custAdrObj);
        custObj.setUser(user1);
        
        
        
        Date date = new GregorianCalendar(2015, 3, 29).getTime();
        Orders order = new Orders("Pending", 1000, date);
             
        
        Payment pymt = new Payment("Credit");
        
        
        order.setOrdItems(ordrItemList);
        order.setPymt(pymt);
        
        List<Orders> orderList = new ArrayList<>();
        orderList.add(order);
        custObj.setOrder(orderList);
        
        
        customerService.createEntity(custObj);
        
                
    }

    
}
