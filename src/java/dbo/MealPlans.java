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
public class MealPlans {
    private int PlanID;
    private int UserID;
    private String PlanName ;
    private Date StartDate;
    private Date EndDate;

    public MealPlans() {
    }

    public MealPlans(int PlanID, int UserID, String PlanName, Date StartDate, Date EndDate) {
        this.PlanID = PlanID;
        this.UserID = UserID;
        this.PlanName = PlanName;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int PlanID) {
        this.PlanID = PlanID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String PlanName) {
        this.PlanName = PlanName;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }
    
    
}
