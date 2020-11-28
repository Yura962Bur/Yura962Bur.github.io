/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.entities;

import java.util.Objects;

/**
 *
 * @author Yuriy
 */
public class TblCategory {
    private int CategoryID;
    private String CategoryName;
    
    public TblCategory()
    {
        
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.CategoryID;
        hash = 17 * hash + Objects.hashCode(this.CategoryName);
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
        final TblCategory other = (TblCategory) obj;
        if (this.CategoryID != other.CategoryID) {
            return false;
        }
        if (!Objects.equals(this.CategoryName, other.CategoryName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TblCategory{" + 
                "CategoryID=" + CategoryID + 
                ", CategoryName=" + CategoryName + 
                '}';
    }
    
        
}
