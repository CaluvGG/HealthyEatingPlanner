/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MealPlanDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class MealPlanDetailDAO {
    public MealPlanDetails getPlanDetail(int detailID) {
        MealPlanDetails meal=null;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [DetailID],[PlanID],[MealID],[DayOfWeek]\n"
                        + "FROM [dbo].[MealPlanDetails]\n"
                        + "WHERE [DetailID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, detailID);
                ResultSet rs=pst.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int planid=rs.getInt("PlanID");
                        int mealid=rs.getInt("MealID");
                        String day=rs.getString("DayOfWeek");
                        meal=new MealPlanDetails(detailID, planid, mealid, day);
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
        return meal;
    }

    public int addDetail(int planID, int mealID, String Day) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[MealPlanDetails] ([PlanID],[MealID],[DayOfWeek])\n"
                        + "VALUES (?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, planID);
                pst.setInt(2, mealID);
                pst.setString(3, Day);
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

    public int UpdateDetail(int planID,int mealID, String day){
        int rs=0;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[MealPlanDetails] \n"
                        + "SET [PlanID]=?,[MealID]=?,[DayOfWeek]=?\n"
                        + "WHERE [DetailID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, planID);
                pst.setInt(2, mealID);
                pst.setString(3, day);
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
