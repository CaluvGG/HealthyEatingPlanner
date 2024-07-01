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
    private int HistoryID;
    private int OrderID;
    private int Status;
    private Date ChangedAt;

    public OrderHistory() {
    }

    public OrderHistory(int HistoryID, int OrderID, int Status, Date ChangedAt) {
        this.HistoryID = HistoryID;
        this.OrderID = OrderID;
        this.Status = Status;
        this.ChangedAt = ChangedAt;
    }

    public int getHistoryID() {
        return HistoryID;
    }

    public void setHistoryID(int HistoryID) {
        this.HistoryID = HistoryID;
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

    public Date getChangedAt() {
        return ChangedAt;
    }

    public void setChangedAt(Date ChangedAt) {
        this.ChangedAt = ChangedAt;
    }
    
}
