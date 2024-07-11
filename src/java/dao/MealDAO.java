/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.Meals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class MealDAO {
    public ArrayList<Meals> getAllMenu() {
        ArrayList<Meals> list=new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT MealID, MenuID, MealName, Description, Type, Recipe, Ingredients\n"
                        + "FROM [dbo].[Meals]";
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int mealid=rs.getInt("MealID");
                        int menuid=rs.getInt("MenuID");
                        String name=rs.getString("MealName");
                        String des=rs.getString("Description");
                        String type=rs.getString("Type");
                        String recipe=rs.getString("Recipe");
                        String ingre=rs.getString("Ingredients");
                        Meals meal=new Meals(mealid, menuid, name, des, type, recipe, ingre);
                        list.add(meal);
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
        return list;
    }
    
    public Meals getMenu(int mealID) {
        Meals meal=null;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT MealID, MenuID, MealName, Description, Type, Recipe, Ingredients\n"
                        + "FROM [dbo].[Meals]\n"
                        + "WHERE MealID=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, mealID);
                ResultSet rs=pst.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int menuid=rs.getInt("MenuID");
                        String name=rs.getString("MealName");
                        String des=rs.getString("Description");
                        String type=rs.getString("Type");
                        String recipe=rs.getString("Recipe");
                        String ingre=rs.getString("Ingredients");
                        meal=new Meals(mealID, menuid, name, des, type, recipe, ingre);
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
    
    public int addMealBaseOnMenu(int menuid, String mealName, String mealDes, String type, String recipe, String ingredient) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Meals] ([MenuID],[MealName],[Description],[Type],[Recipe],[Ingredients])\n"
                        + "VALUES (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menuid);
                pst.setString(2, mealName);
                pst.setString(3, mealDes);
                pst.setString(4, type);
                pst.setString(5, recipe);
                pst.setString(6, ingredient);
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
    
    public int addMeal(String mealName, String mealDes, String type, String recipe, String ingredient) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Meals] ([MealName],[Description],[Type],[Recipe],[Ingredients])\n"
                        + "VALUES (?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, mealName);
                pst.setString(2, mealDes);
                pst.setString(3, type);
                pst.setString(4, recipe);
                pst.setString(5, ingredient);
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
    
    public int delMenu(int mealID) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM [dbo].[Menu] \n"
                        + "WHERE [MealID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, mealID);
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
    
    public int UpdateMeal(int menuID, String name, String des, String type, String recipe, String ingre, int mealID){
        int rs=0;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[Meals]\n"
                        + "SET [MenuID]=?,[MealName]=?,[Description]=?,[Type]=?,[Recipe]=?,[Ingredients]=?\n"
                        + "WHERE [MealID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, menuID);
                pst.setString(2, name);
                pst.setString(3, des);
                pst.setString(4, type);
                pst.setString(5, recipe);
                pst.setString(6, ingre);
                pst.setInt(7, mealID);
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
