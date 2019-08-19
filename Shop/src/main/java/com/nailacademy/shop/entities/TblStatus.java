/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nailacademy.shop.entities;

/**
 *
 * @author Yuriy
 */
public class TblStatus {
    private int StatusID;
    private int NameOfStatus;
    
    public TblStatus()
    {
        
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

    public int getNameOfStatus() {
        return NameOfStatus;
    }

    public void setNameOfStatus(int NameOfStatus) {
        this.NameOfStatus = NameOfStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.StatusID;
        hash = 67 * hash + this.NameOfStatus;
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
        final TblStatus other = (TblStatus) obj;
        if (this.StatusID != other.StatusID) {
            return false;
        }
        if (this.NameOfStatus != other.NameOfStatus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TblStatus{" + 
                "StatusID=" + StatusID +
                ", NameOfStatus=" + NameOfStatus
                + '}';
    }
    
    
}
