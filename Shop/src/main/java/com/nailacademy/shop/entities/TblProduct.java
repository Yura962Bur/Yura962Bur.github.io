/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.entities;

import java.util.Objects;


public class TblProduct {
    private int ProductID;
    private String ProductName;
    private int CategoryID;
    private double Cost;
    private int Quantity;
    private String Description;
    private String PhotoPath;
    
    public TblProduct()
    {
        
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public void setPhotoPath(String PhotoPath) {
        this.PhotoPath = PhotoPath;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.ProductID;
        hash = 17 * hash + Objects.hashCode(this.ProductName);
        hash = 17 * hash + this.CategoryID;
        hash = 17 * hash + Objects.hashCode(this.Cost);
        hash = 17 * hash + this.Quantity;
        hash = 17 * hash + Objects.hashCode(this.Description);
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
        final TblProduct other = (TblProduct) obj;
        if (this.ProductID != other.ProductID) {
            return false;
        }
        if (this.CategoryID != other.CategoryID) {
            return false;
        }
        if (this.Quantity != other.Quantity) {
            return false;
        }
        if (!Objects.equals(this.ProductName, other.ProductName)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.Cost, other.Cost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TblProduct{" 
                + "ProductID=" + ProductID +
                ", ProductName=" + ProductName + ","
                + " CategoryID=" + CategoryID + ", "
                + "Cost=" + Cost + ","
                + " Quantity=" + Quantity +
                ", Description=" + Description + 
                '}';
    }
    
    
}
