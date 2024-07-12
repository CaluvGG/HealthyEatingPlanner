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
public class OrderHistory {
    private int OrderHistoryID;
    private int OrderID;
    private int Status;
    private Date CompletionDate;

    public OrderHistory() {
    }

    public OrderHistory(int OrderHistoryID, int OrderID, int Status, Date CompletionDate) {
        this.OrderHistoryID = OrderHistoryID;
        this.OrderID = OrderID;
        this.Status = Status;
        this.CompletionDate = CompletionDate;
    }

    public int getOrderHistoryID() {
        return OrderHistoryID;
    }

    public void setOrderHistoryID(int OrderHistoryID) {
        this.OrderHistoryID = OrderHistoryID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Date getCompletionDate() {
        return CompletionDate;
    }

    public void setCompletionDate(Date CompletionDate) {
        this.CompletionDate = CompletionDate;
    }
    
}
