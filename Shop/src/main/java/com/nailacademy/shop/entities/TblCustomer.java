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
public class TblCustomer {
    private int CustomerID;
    private String Name;
    private String SurName;
    private String FatherName;
    private String Email;
    private String Password;
    private String Phone;
    private String City;
    
    public TblCustomer()
    {
        
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String SurName) {
        this.SurName = SurName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.CustomerID;
        hash = 31 * hash + Objects.hashCode(this.Name);
        hash = 31 * hash + Objects.hashCode(this.SurName);
        hash = 31 * hash + Objects.hashCode(this.FatherName);
        hash = 31 * hash + Objects.hashCode(this.Email);
        hash = 31 * hash + Objects.hashCode(this.Password);
        hash = 31 * hash + Objects.hashCode(this.Phone);
        hash = 31 * hash + Objects.hashCode(this.City);
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
        final TblCustomer other = (TblCustomer) obj;
        if (this.CustomerID != other.CustomerID) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.SurName, other.SurName)) {
            return false;
        }
        if (!Objects.equals(this.FatherName, other.FatherName)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        if (!Objects.equals(this.Phone, other.Phone)) {
            return false;
        }
        if (!Objects.equals(this.City, other.City)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TblCustomer{" + 
                "CustomerID=" + CustomerID 
                + ", Name=" + Name + 
                ", SurName=" + SurName + 
                ", FatherName=" + FatherName
                + ", Email=" + Email 
                + ", Password=" + Password 
                + ", Phone=" + Phone 
                + ", City=" + City
                + '}';
    }
    
    
}
