/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.Menu;
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
public class MenuDAO {
    public ArrayList<Menu> getAllMenu() {
        ArrayList<Menu> list=new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [MenuID],[MenuName],[Description],[img-url]\n"
                        + "FROM [dbo].[Menu]";
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int id=rs.getInt("MenuID");
                        String name=rs.getString("MenuName");
                        String des=rs.getString("Description");
                        String img=rs.getString("img-url");
                        Menu menu=new Menu(id, name, des, img);
                        list.add(menu);
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
    
    public ArrayList<Menu> getMenu(String menuName) {
        ArrayList<Menu> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT [MenuID],[MenuName],[Description],[img-url]\n"
                        + "FROM [dbo].[Menu]\n"
                        + "WHERE [MenuName] like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + menuName + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("MenuID");
                        String name=rs.getString("MenuName");
                        String des = rs.getString("Description");
                        String img = rs.getString("img-url");
                        list.add(new Menu(id, name, des, img));
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
    
    public int addMenu(String menuName, String menuDes) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Menu] ([MenuName], [Description]) \n"
                        + "VALUES (?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, menuName);
                pst.setString(2, menuDes);
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
    
    public int delMenu(int menuID) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM [dbo].[Menu] \n"
                        + "WHERE [MenuID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menuID);
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
    
    public int UpdateMenu(String name, String des, int id){
        int rs=0;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[Menu]\n"
                        + "SET [MenuName]=?,[Description]=?\n"
                        + "WHERE [MenuID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, des);
                pst.setInt(3, id);
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
