/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.Orders;
import dbo.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class OrderDAO {
    public ArrayList<Orders> getAllOrders() {
        ArrayList<Orders> list=new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [OrderID],[UserID],[OrderDate],[TotalAmount]\n"
                        + "FROM [dbo].[Orders]";
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int orderid=rs.getInt("OrderID");
                        int userid=rs.getInt("UserID");
                        String date=rs.getString("OrderDate");
                        int total=rs.getInt("TotalAmount");
                        Orders order=new Orders(orderid, userid, date, total);
                        list.add(order);
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
    
    public int addOrder(int userID, String date, int total) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Orders] ([UserID], [OrderDate],[TotalAmount])\n"
                        + "VALUES (?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setString(2, date);
                pst.setInt(3, total);
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

    public Orders getOrder(int ID) {
        Orders order=null;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [OrderID],[UserID],[OrderDate],[TotalAmount]\n"
                        + "FROM [dbo].[Orders]\n"
                        + "WHERE [OrderID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, ID);
                ResultSet rs=pst.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int userid=rs.getInt("UserID");
                        String date=rs.getString("OrderDate");
                        int total=rs.getInt("TotalAmount");
                        order=new Orders(ID, userid, date, total);
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
        return order;
    }
    
    public int UpdateOrder(String date, int total, int id){
        int rs=0;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[Orders]\n"
                        + "SET [OrderDate]=?,[TotalAmount]=?\n"
                        + "WHERE [OrderID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, date);
                pst.setInt(2, total);
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
