/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.dao;

import com.nailacademy.shop.entities.TblOrder;
import java.util.List;

/**
 *
 * @author Yuriy
 */
public interface OrderDAO {
    
    //create
    void add(TblOrder order);
    
    //read
    List<TblOrder> getAll();
    
    TblOrder getByID(int ID);
    
    //update
    void update(TblOrder order);
    
    //delete
    void remove(TblOrder order);
    
}
