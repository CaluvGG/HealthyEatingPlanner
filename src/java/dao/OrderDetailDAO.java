/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class OrderDetailDAO {
    public ArrayList<OrderDetails> getDetail(int orderID) {
        ArrayList<OrderDetails> list=new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [OrderDetailID],[OrderID],[MealID],[Quantity],[Price]\n"
                        + "FROM [dbo].[OrderDetails]\n"
                        + "WHERE [OrderID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, orderID);
                ResultSet rs=pst.executeQuery();
                if(rs!=null){
                    while(rs.next()){
                        int detailid=rs.getInt("OrderDetailID");
                        int mealid=rs.getInt("MealID");
                        int quantity=rs.getInt("Quantity");
                        int price=rs.getInt("Price");
                        list.add(new OrderDetails(detailid, orderID, mealid, quantity, price));
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
