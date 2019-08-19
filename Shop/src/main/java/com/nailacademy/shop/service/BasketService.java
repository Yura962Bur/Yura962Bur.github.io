/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.service;

import com.nailacademy.shop.dao.OrderDAO;
import com.nailacademy.shop.dao.Util;
import com.nailacademy.shop.entities.TblOrder;
import com.nailacademy.shop.entities.TblOrderDetails;
import com.nailacademy.shop.entities.TblProduct;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class BasketService extends Util {
    
    private final int basketStatus=5;
    private final int customerId=3;
    
    public void addHeader(TblOrder order) {
        Connection conn = getConnectionToMyDB();

        PreparedStatement stmt = null;
        
        String sql = "insert into tbl_Order ([Customer_ID], [OrderDate], [StatusID], [TotalAmount]) values (?,?,?,?);";
        
        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, order.getCustomerID());
            stmt.setDate(2, order.getOrderDate());
            stmt.setInt(3, order.getStatusID());
            stmt.setBigDecimal(4, order.getTotalAmount());
            
            stmt.executeUpdate();           
        }catch (SQLException ex) {
            Logger.getLogger(BasketService.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BasketService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn !=null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(BasketService.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }

    public void addBasketItem(TblProduct product){
        TblOrder header = getBasketHeader();
        OrderDetailService orderDetailService = new OrderDetailService();
        
        TblOrderDetails item = orderDetailService.getByProductID(header.getOrderID(), product.getProductID());

        if (item == null) {
            item = new TblOrderDetails();
            item.setOrderID(header.getOrderID());
            item.setQuantity(1);
            item.setProductID(product.getProductID());
            item.setCost(product.getCost());
            item.setAmount(item.getQuantity()*item.getCost());

            orderDetailService.add(item);
        }
        else {
            item.setQuantity(item.getQuantity()+ 1);
            item.setAmount(item.getAmount()+product.getCost());
            orderDetailService.update(item);
        }
    }
    
    private TblOrder getBasketHeader(){
        
        Connection conn = getConnectionToMyDB();

        PreparedStatement stmt = null;
        ResultSet resSet =null;
        
        String sql = "select [OrderID], [Customer_ID], [OrderDate], [StatusID], [TotalAmount] from tbl_Order where [StatusID]=? and [Customer_ID]=?";
        
        
        TblOrder basketHeader = new TblOrder();
        
        try{
           stmt = conn.prepareStatement(sql);
           stmt.setInt(1, basketStatus);
           stmt.setInt(2, customerId);
           resSet = stmt.executeQuery();
           
           if (resSet.next()){
                basketHeader.setOrderID(resSet.getInt("OrderID"));
                basketHeader.setOrderDate(resSet.getDate("OrderDate"));
                basketHeader.setCustomerID(resSet.getInt("Customer_ID"));
                basketHeader.setStatusID(resSet.getInt("StatusID"));
                basketHeader.setTotalAmount(resSet.getBigDecimal("TotalAmount"));
           } else {
               basketHeader.setOrderDate(Date.valueOf( LocalDate.now()));
               basketHeader.setCustomerID(customerId);
               basketHeader.setStatusID(basketStatus);
               basketHeader.setTotalAmount(BigDecimal.ZERO);
               
               addHeader(basketHeader);
               basketHeader = getBasketHeader();
           }
        }catch (SQLException ex) {
            Logger.getLogger(BasketService.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (resSet != null) {
                try {
                    resSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BasketService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BasketService.class.getName()).log(Level.SEVERE, null, ex);
                }
            if (conn !=null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(BasketService.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            }
        }           
        
        return basketHeader;
    }

    public List<TblOrderDetails> getBasketItems(){
        TblOrder header = getBasketHeader();
        OrderDetailService orderDetailService = new OrderDetailService();
        
        return orderDetailService.getByHeaderId(header.getOrderID());
    }
    
    public void changeBasketItemQuantity(int orderDetailId, int itemQuantity){
        OrderDetailService orderDetailService = new OrderDetailService();
        TblOrderDetails item = orderDetailService.getByOrderDetailID(orderDetailId);

        if (item != null) {
            item.setQuantity(itemQuantity);
            item.setAmount(item.getQuantity() * item.getCost());
            orderDetailService.update(item);
        }
    }
}
