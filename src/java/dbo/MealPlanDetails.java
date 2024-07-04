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
public class MealPlanDetails {
    private int DetailID;
    private int PlanID;
    private int MealID;
    private String DayOfWeek;

    public MealPlanDetails() {
    }

    public MealPlanDetails(int DetailID, int PlanID, int MealID, String DayOfWeek) {
        this.DetailID = DetailID;
        this.PlanID = PlanID;
        this.MealID = MealID;
        this.DayOfWeek = DayOfWeek;
    }

    public int getDetailID() {
        return DetailID;
    }

    public void setDetailID(int DetailID) {
        this.DetailID = DetailID;
    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int PlanID) {
        this.PlanID = PlanID;
    }

    public int getMealID() {
        return MealID;
    }

    public void setMealID(int MealID) {
        this.MealID = MealID;
    }

    public String getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(String DayOfWeek) {
        this.DayOfWeek = DayOfWeek;
    }
    
}
