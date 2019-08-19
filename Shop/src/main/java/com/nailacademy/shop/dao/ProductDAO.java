/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.dao;

import com.nailacademy.shop.entities.TblProduct;
import java.util.List;

/**
 *
 * @author Yuriy
 */
public interface ProductDAO {
    
    //create
    void add(TblProduct product);
    
    //read
    List<TblProduct> getAll();
    
    TblProduct getByID(int ID);
    
    //update
    void update(TblProduct product);
    
    //delete
    void remove(TblProduct product);
    
    
}
