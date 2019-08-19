/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.dao;

import com.nailacademy.shop.entities.TblCategory;
import java.util.List;

/**
 *
 * @author Yuriy
 */
public interface CategoryDAO {
    
    //create
    void add(TblCategory category);
    
    //read
    List<TblCategory> getAll();
    
    TblCategory getByID(int ID);
    
    //update
    void update(TblCategory category);
    
    //delete
    void remove(TblCategory category);
}
