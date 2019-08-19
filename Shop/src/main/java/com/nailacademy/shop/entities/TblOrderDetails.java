/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.entities;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Yuriy
 */
public class TblOrderDetails {
    private int OrderDetailsID;
    private int OrderID;
    private int ProductID;
    private String ProductName;
    private int Quantity;
    private double Cost;
    private double Amount;
    
    public TblOrderDetails()
    {
        
    }

    public int getOrderDetailsID() {
        return OrderDetailsID;
    }

    public void setOrderDetailsID(int OrderDetailsID) {
        this.OrderDetailsID = OrderDetailsID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
    public void setProductName(String ProductName){
        this.ProductName = ProductName;
    }

    public String getProductName(){
        return this.ProductName;
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.OrderDetailsID;
        hash = 37 * hash + this.OrderID;
        hash = 37 * hash + this.ProductID;
        hash = 37 * hash + this.Quantity;
        hash = 37 * hash + Objects.hashCode(this.Cost);
        hash = 37 * hash + Objects.hashCode(this.Amount);
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
        final TblOrderDetails other = (TblOrderDetails) obj;
        if (this.OrderDetailsID != other.OrderDetailsID) {
            return false;
        }
        if (this.OrderID != other.OrderID) {
            return false;
        }
        if (this.ProductID != other.ProductID) {
            return false;
        }
        if (this.Quantity != other.Quantity) {
            return false;
        }
        if (!Objects.equals(this.Cost, other.Cost)) {
            return false;
        }
        if (!Objects.equals(this.Amount, other.Amount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TblOrderDetails{" +
                "OrderDetailsID=" + OrderDetailsID +
                ", OrderID=" + OrderID + 
                ", ProductID=" + ProductID + 
                ", Quantity=" + Quantity + 
                ", Cost=" + Cost + 
                ", Amount=" + Amount + 
                '}';
    }
    
    
}
