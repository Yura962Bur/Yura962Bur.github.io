/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.service;

import com.nailacademy.shop.dao.CategoryDAO;
import com.nailacademy.shop.dao.Util;
import com.nailacademy.shop.entities.TblCategory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuriy
 */
public class CategoryService extends Util implements CategoryDAO{
    
    Connection conn = getConnectionToMyDB();
    
    @Override
    public void add(TblCategory category){
        
    }
    
    @Override
    public List<TblCategory> getAll(){
        
        List<TblCategory> categoryList = new ArrayList(); 
        String sql = " SELECT CategoryID, CategoryName FROM tbl_Category";
        
        try{
            Statement stmt=null;
            stmt = conn.createStatement();
            ResultSet resSet=stmt.executeQuery(sql);
            
            while(resSet.next()){
                TblCategory category = new TblCategory();
                category.setCategoryID(resSet.getInt("CategoryID"));
                category.setCategoryName(resSet.getString("CategoryName"));
                
                categoryList.add(category);
                }          
            conn.close();
            }catch (SQLException ex) {
                    Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoryList;
    }
    
    @Override
    public TblCategory getByID(int ID){
        return null;
    }
    
    @Override
    public void update(TblCategory category){
        
    }
    
    @Override
    public void remove(TblCategory category){
        
    }
}
