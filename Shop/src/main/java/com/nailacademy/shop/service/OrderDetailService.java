/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.service;

import com.nailacademy.shop.dao.OrderDetails;
import com.nailacademy.shop.dao.Util;
import com.nailacademy.shop.entities.TblOrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael_Buranov
 */
public class OrderDetailService extends Util implements OrderDetails{

    @Override
    public void add(TblOrderDetails orderDetails) {
        Connection conn = getConnectionToMyDB();

        PreparedStatement stmt = null;
        
        String sql = "insert into tbl_Order_Details ([Order_ID] ,[ProductID] ,[Quantity] ,[Cost], [Amount]) values (?,?,?,?,?);";
        
        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, orderDetails.getOrderID());
            stmt.setInt(2, orderDetails.getProductID());
            stmt.setInt(3, orderDetails.getQuantity());
            stmt.setDouble(4, orderDetails.getCost());
            stmt.setDouble(5, orderDetails.getAmount());
            
            stmt.executeUpdate();           
        }catch (SQLException ex) {
            Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn !=null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
        
    }

    @Override
    public List<TblOrderDetails> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TblOrderDetails getByID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TblOrderDetails getByProductID(int headerId, int productId) {
       Connection conn = getConnectionToMyDB();
       PreparedStatement preparedStatement = null;
       String sql ="SELECT [OrderDetailID],[Order_ID],[ProductID],[Quantity],[Cost],[Amount] FROM tbl_Order_Details WHERE Order_ID =? and ProductID =?";
       
       TblOrderDetails orderDetails = null;
       
       try{
           preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setInt(1,headerId);
           preparedStatement.setInt(2,productId);
           
           ResultSet rs = preparedStatement.executeQuery();
           
           if (rs.next()){
               orderDetails = new TblOrderDetails();
               orderDetails.setOrderDetailsID(rs.getInt("OrderDetailID"));
               orderDetails.setOrderID(rs.getInt("Order_ID"));
               orderDetails.setProductID(rs.getInt("ProductID"));
               orderDetails.setQuantity(rs.getInt("Quantity"));
               orderDetails.setCost(rs.getDouble("Cost"));
               orderDetails.setAmount(rs.getDouble("Amount"));
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
        return orderDetails;
        
    }
    
    @Override
    public void update(TblOrderDetails orderDetails) {
        Connection conn = getConnectionToMyDB();

        PreparedStatement stmt = null;
        String sql = "update tbl_Order_Details set Order_ID=?, ProductID=?, Quantity=?, Cost=?, Amount=? where OrderDetailID = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, orderDetails.getOrderID());
            stmt.setInt(2, orderDetails.getProductID());
            stmt.setInt(3, orderDetails.getQuantity());
            stmt.setDouble(4, orderDetails.getCost());
            stmt.setDouble(5, orderDetails.getAmount());
            stmt.setInt(6, orderDetails.getOrderDetailsID());
            
            stmt.executeUpdate();           
        }catch (SQLException ex) {
            Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn !=null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }

    @Override
    public void remove(TblOrderDetails orderDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<TblOrderDetails> getByHeaderId (int headerID){
       Connection conn = getConnectionToMyDB();
       PreparedStatement preparedStatement = null;
       String sql ="SELECT d.OrderDetailID,d.Order_ID, d.ProductID, d.Quantity, d.Cost, d.Amount, p.productName " + 
               " FROM tbl_Order_Details d inner join tbl_Product p on d.productId=p.productId" + 
               " WHERE d.Order_ID =?";
       
       List<TblOrderDetails> resultList = new ArrayList();
       TblOrderDetails orderDetails = null;
       
       try{
           preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setInt(1,headerID);
           
           ResultSet rs = preparedStatement.executeQuery();
           
           while (rs.next()){
               orderDetails = new TblOrderDetails();
               orderDetails.setOrderDetailsID(rs.getInt("OrderDetailID"));
               orderDetails.setOrderID(rs.getInt("Order_ID"));
               orderDetails.setProductID(rs.getInt("ProductID"));
               orderDetails.setQuantity(rs.getInt("Quantity"));
               orderDetails.setCost(rs.getDouble("Cost"));
               orderDetails.setAmount(rs.getDouble("Amount"));
               orderDetails.setProductName(rs.getString("productName"));
               
               resultList.add(orderDetails);
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
        return resultList;        
    }
    
    
    public void removeByOrderDetaiId(int orderDetailId) {
        Connection conn = getConnectionToMyDB();

        PreparedStatement stmt = null;
        String sql = "delete from tbl_Order_Details where OrderDetailID = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, orderDetailId);
            
            stmt.executeUpdate();           
        }catch (SQLException ex) {
            Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn !=null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailService.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
        
    }
    
    public TblOrderDetails getByOrderDetailID (int orderDetailID){
       Connection conn = getConnectionToMyDB();
       PreparedStatement preparedStatement = null;
       String sql ="SELECT [OrderDetailID],[Order_ID],[ProductID],[Quantity],[Cost],[Amount] FROM tbl_Order_Details WHERE OrderDetailID =?" ;
       
       TblOrderDetails orderDetails = null;
       
       try{
           preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setInt(1,orderDetailID);
           
           ResultSet rs = preparedStatement.executeQuery();
           
           if (rs.next()){
               orderDetails = new TblOrderDetails();
               orderDetails.setOrderDetailsID(rs.getInt("OrderDetailID"));
               orderDetails.setOrderID(rs.getInt("Order_ID"));
               orderDetails.setProductID(rs.getInt("ProductID"));
               orderDetails.setQuantity(rs.getInt("Quantity"));
               orderDetails.setCost(rs.getDouble("Cost"));
               orderDetails.setAmount(rs.getDouble("Amount"));
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
        return orderDetails;
    }
    
}
