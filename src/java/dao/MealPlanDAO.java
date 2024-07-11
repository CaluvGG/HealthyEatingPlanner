/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MealPlans;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class MealPlanDAO {
    public MealPlans getplan(int planID) {
        MealPlans plan=null;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [PlanID],[UserID],[PlanName],[StartDate],[EndDate]\n"
                        + "FROM [dbo].[MealPlans]\n"
                        + "WHERE [PlanID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, planID);
                ResultSet rs=pst.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int planid=rs.getInt("PlanID");
                        int userid=rs.getInt("UserID");
                        String name=rs.getString("PlanName");
                        Date start=rs.getDate("StartDate");
                        Date end=rs.getDate("EndDate");
                        plan=new MealPlans(planid, userid, name, start, end);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cn!=null) cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return plan;
    }
    
    public int addPlan(String userID, String name, Date start, Date end) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[MealPlans] ([UserID],[PlanName],[StartDate],[EndDate])\n"
                        + "VALUES (?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setString(2, name);
                pst.setDate(3, start);
                pst.setDate(4, end);
                result = pst.executeUpdate();
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
        return result;
    }
    
    public int delPlan(int planID) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM [dbo].[MealPlans]\n"
                        + "WHERE [PlanID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, planID);
                result = pst.executeUpdate();
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
        return result;
    }
    
    public int UpdatePlan(String name,Date start, Date end){
        int rs=0;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[MealPlans]\n"
                        + "SET [PlanName]=?,[StartDate]=?,[EndDate]=?\n"
                        + "WHERE [PlanID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setDate(2, start);
                pst.setDate(3, end);
                rs=pst.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cn!=null) cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return rs;
    }
}
