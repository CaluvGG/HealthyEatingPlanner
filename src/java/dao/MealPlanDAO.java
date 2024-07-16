/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MealPlanDetails;
import dbo.MealPlans;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class MealPlanDAO {
    public ArrayList<MealPlans> getPersonalMealPlans(int userId) {
        ArrayList<MealPlans> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT PlanID, PlanName, StartDate, EndDate FROM MealPlans WHERE UserID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userId);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int planId = rs.getInt("PlanID");
                    String planName = rs.getString("PlanName");
                    String startDate = rs.getString("StartDate");
                    String endDate = rs.getString("EndDate");
                    MealPlans plan = new MealPlans(planId, userId, planName, startDate, endDate);
                    list.add(plan);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void createPersonalMealPlan(MealPlans plan) {
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO PersonalMealPlans (UserID, PlanName, StartDate, EndDate) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, plan.getUserID());
                pst.setString(2, plan.getPlanName());
                pst.setString(3, plan.getStartDate());
                pst.setString(4, plan.getEndDate());
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updatePersonalMealPlan(MealPlans plan) {
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE PersonalMealPlans SET PlanName = ?, StartDate = ?, EndDate = ? WHERE PlanID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, plan.getPlanName());
                pst.setString(2, plan.getStartDate());
                pst.setString(3, plan.getEndDate());
                pst.setInt(4, plan.getPlanID());
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletePersonalMealPlan(int planId) {
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM PersonalMealPlans WHERE PlanID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, planId);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<MealPlanDetails> getMealPlanDetails(int planId) {
        ArrayList<MealPlanDetails> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT PlanDetailID, MealID, DayOfWeek FROM MealPlanDetails WHERE PlanID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, planId);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int detailId = rs.getInt("PlanDetailID");
                    int mealId = rs.getInt("MealID");
                    String dayOfWeek = rs.getString("DayOfWeek");
                    MealPlanDetails detail = new MealPlanDetails(detailId, planId, mealId, dayOfWeek);
                    list.add(detail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void addMealToPlan(MealPlanDetails detail) {
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO MealPlanDetails (PlanID, MealID, DayOfWeek) VALUES (?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, detail.getPlanID());
                pst.setInt(2, detail.getMealID());
                pst.setString(3, detail.getDayOfWeek());
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeMealFromPlan(int detailId) {
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM MealPlanDetails WHERE PlanDetailID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, detailId);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
