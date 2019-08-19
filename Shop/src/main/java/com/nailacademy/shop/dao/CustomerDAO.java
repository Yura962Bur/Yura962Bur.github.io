/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.dao;

import com.nailacademy.shop.entities.TblCustomer;
import java.util.List;

/**
 *
 * @author Yuriy
 */
public interface CustomerDAO {
    
    
    //create
    void add(TblCustomer customer);
    
    //read
    List<TblCustomer> getAll();
    
    TblCustomer getByID(int ID);
    
    //update
    void update(TblCustomer customer);
    
    //delete
    void remove(TblCustomer customer);
    
}
