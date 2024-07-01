/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Order {
    private int OrderID;
    private int UserID;
    private Date OrderDate;
    private Date DeliveryDate;
    private int Status;
    private int AddressID;

    public Order() {
    }

    public Order(int OrderID, int UserID, Date OrderDate, Date DeliveryDate, int Status, int AddressID) {
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.OrderDate = OrderDate;
        this.DeliveryDate = DeliveryDate;
        this.Status = Status;
        this.AddressID = AddressID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public int getUserID() {
        return UserID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public Date getDeliveryDate() {
        return DeliveryDate;
    }

    public int getStatus() {
        return Status;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setDeliveryDate(Date DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public void setAddressID(int AddressID) {
        this.AddressID = AddressID;
    }
    
}
