/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.OrderHistory;
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
public class OrderHistoryDAO {
   public ArrayList<OrderHistory> getAllOrders() {
        ArrayList<OrderHistory> list=new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [OrderHistoryID],[OrderID],[Status],[CompletionDate]\n"
                        + "FROM [dbo].[OrderHistory]";
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int historyid=rs.getInt("OrderHistoryID");
                        int orderid=rs.getInt("OrderID");
                        int status=rs.getInt("Status");
                        Date date=rs.getDate("CompletionDate");
                        OrderHistory order=new OrderHistory(historyid, orderid, status, date);
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
    
    public int addHistory(int orderID, int status, Date date) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[OrderHistory] ([OrderID], [Status], [CompletionDate])\n"
                        + "VALUES (?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderID);
                pst.setInt(2, status);
                pst.setDate(3, date);
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

    public OrderHistory getOrder(int ID) {
        OrderHistory history=null;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [OrderHistoryID],[OrderID],[Status],[CompletionDate]\n"
                        + "FROM [dbo].[OrderHistory]\n"
                        + "WHERE [OrderHistoryID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, ID);
                ResultSet rs=pst.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int orderid=rs.getInt("OrderID");
                        int status=rs.getInt("Status");
                        Date date=rs.getDate("CompletionDate");
                        history=new OrderHistory(ID, orderid, status, date);
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
        return history;
    }
    
    public int UpdateHistory(int status, Date date, int id){
        int rs=0;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[OrderHistory]\n"
                        + "SET [Status]=?,[CompletionDate]=?\n"
                        + "WHERE [OrderHistoryID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setDate(2, date);
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
