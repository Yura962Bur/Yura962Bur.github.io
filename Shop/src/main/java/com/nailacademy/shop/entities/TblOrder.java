/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Yuriy
 */
public class TblOrder {
 
    public TblOrder()
    {
        
    }
    private int OrderID;
    private int CustomerID;
    private Date OrderDate;
    private int StatusID;
    private BigDecimal TotalAmount;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.OrderID;
        hash = 97 * hash + this.CustomerID;
        hash = 97 * hash + Objects.hashCode(this.OrderDate);
        hash = 97 * hash + this.StatusID;
        hash = 97 * hash + Objects.hashCode(this.TotalAmount);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TblOrder other = (TblOrder) obj;
        if (this.OrderID != other.OrderID) {
            return false;
        }
        if (this.CustomerID != other.CustomerID) {
            return false;
        }
        if (this.StatusID != other.StatusID) {
            return false;
        }
        if (!Objects.equals(this.OrderDate, other.OrderDate)) {
            return false;
        }
        if (!Objects.equals(this.TotalAmount, other.TotalAmount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TblOrder{" + 
                "OrderID=" + OrderID +
                ", CustomerID=" + CustomerID 
                + ", OrderDate=" + OrderDate +
                ", StatusID=" + StatusID + 
                ", TotalAmount=" + TotalAmount 
                + '}';
    }
    
    
}
