/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.Orders;
import dbo.Users;
import java.sql.Connection;
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
}
