/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.dao;

import com.nailacademy.shop.entities.TblOrderDetails;
import java.util.List;

/**
 *
 * @author Yuriy
 */
public interface OrderDetails {
    
    //create
    void add(TblOrderDetails orderDetails);
    
    //read
    List<TblOrderDetails> getAll();
    
    TblOrderDetails getByID(int ID);
    
    //update
    void update(TblOrderDetails orderDetails);
    
    //delete
    void remove(TblOrderDetails orderDetails);
    
}
