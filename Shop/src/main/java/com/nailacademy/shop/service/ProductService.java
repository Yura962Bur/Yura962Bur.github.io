/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.service;

import com.nailacademy.shop.dao.ProductDAO;
import com.nailacademy.shop.dao.Util;
import com.nailacademy.shop.entities.TblProduct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuriy
 */
public class ProductService extends Util implements ProductDAO {
    
    Connection conn= getConnectionToMyDB();
    
    @Override
    public void add(TblProduct product){
        PreparedStatement preparedStatement = null;
        
        String sql = "INSERT INTO tbl_Product (ProductID, ProductName, Category_ID, Cost, Quantity, Description) VALUES (?,?,?,?,?,?)";
        
        try {
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setInt(1, product.getProductID());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getCategoryID());
            preparedStatement.setDouble(4, product.getCost());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setString(6, product.getDescription());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public List<TblProduct> getAll(){
        String sql = " SELECT ProductID, ProductName, Cost, Quantity, Description, PhotoPath FROM tbl_Product";
        return fillFromRS(sql);    
    }

    private List<TblProduct> fillFromRS(String sql){
        List<TblProduct> productList = new ArrayList();
        Statement stmt = null;
        ResultSet resSet = null;
        
        try {
            stmt= conn.createStatement();
            resSet=stmt.executeQuery(sql);
            
            while(resSet.next()){
                TblProduct product = new TblProduct();
                product.setProductID(resSet.getInt("ProductID"));
                product.setProductName(resSet.getString("ProductName"));
                product.setCost(resSet.getDouble("Cost"));
                product.setQuantity(resSet.getInt("Quantity"));
                product.setDescription(resSet.getString("Description"));
                product.setPhotoPath(resSet.getString("PhotoPath"));
                
                productList.add(product);
            }
            conn.close();
            stmt.close();
            resSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resSet != null) {
                try {
                    resSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
                }
            if (conn !=null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            }
        }
        return productList;
    }
    
    public List<TblProduct> getByCategory(String category){
        String sql = " SELECT ProductID, ProductName, Cost, Quantity, Description, PhotoPath FROM tbl_Product WHERE Category_ID = " + category;        
        return fillFromRS(sql);        
    }
    
    @Override
    public TblProduct getByID(int ID){
       PreparedStatement preparedStatement = null;
       
       String sql ="SELECT ProductID, ProductName, Category_ID, Cost, Quantity, Description, PhotoPath FROM tbl_Product WHERE ProductID=?";
       TblProduct product = new TblProduct();
       try{
           preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setInt(1,ID);
           
           ResultSet resultSet = preparedStatement.executeQuery();
           
           if (resultSet.next()){
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setCategoryID(resultSet.getInt("Category_ID"));
                product.setCost(resultSet.getDouble("Cost"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setDescription(resultSet.getString("Description"));
                product.setPhotoPath(resultSet.getString("PhotoPath"));           
           }
       }catch(SQLException ex){
           ex.printStackTrace();
       }finally{
           if(preparedStatement != null){
               try {
                   preparedStatement.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           if(conn != null){
               try {
                   conn.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
        return product;
    }
    
    @Override
    public void update(TblProduct product){
        PreparedStatement preparedStatement = null;
       
       String sql ="UPDATE Tbl_PRODUCT SET ProductName=?, CategoryID=?, Cost=?, Quantity=?, Description=? WHERE PRODUCTID=?";
       
        try {
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getCategoryID());
            preparedStatement.setDouble(3,product.getCost());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getProductID());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           if(preparedStatement != null){
               try {
                   preparedStatement.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           if(conn != null){
               try {
                   conn.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    }

    @Override
    public void remove(TblProduct product) {
        PreparedStatement preparedStatement = null;
       
       String sql ="DELETE FROM Tbl_PRODUCT WHERE PRODUCTID=?";
       
      
            try {
                preparedStatement = conn.prepareStatement(sql);
                
                preparedStatement.setInt(1, product.getProductID());
                
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if(preparedStatement != null){
               try {
                   preparedStatement.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           }
       }
    }
    

