/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

/**
 *
 * @author user
 */
public class OrderDetail {
    private int OrderDetailID;
    private int OrderID;
    private int MealID;
    private int Quantity;

    public OrderDetail() {
    }

    public OrderDetail(int OrderDetailID, int OrderID, int MealID, int Quantity) {
        this.OrderDetailID = OrderDetailID;
        this.OrderID = OrderID;
        this.MealID = MealID;
        this.Quantity = Quantity;
    }

    public int getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(int OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getMealID() {
        return MealID;
    }

    public void setMealID(int MealID) {
        this.MealID = MealID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
}
