/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.dao;

import com.nailacademy.shop.entities.TblStatus;
import java.util.List;

/**
 *
 * @author Yuriy
 */
public interface StatusDAO {
 
    //create
    void add(TblStatus status);
    
    //read
    List<TblStatus> getAll();
    
    TblStatus getByID(int ID);
    
    //update
    void update(TblStatus status);
    
    //delete
    void remove(TblStatus status);
    
    
}
