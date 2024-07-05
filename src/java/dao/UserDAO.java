/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.Users;
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
public class UserDAO {
    public ArrayList<Users> getAllUsers() {
        ArrayList<Users> list=new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [UserID],[FirstName],[LastName],[Email],[Phone],[Address],[Role]\n" 
                        + "FROM [dbo].[Users]";
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        int id=rs.getInt("UserID");
                        String firstname=rs.getString("FirstName");
                        String lastname=rs.getString("LastName");
                        String email=rs.getString("Email");
                        String phone=rs.getString("Phone");
                        String address=rs.getString("Address");
                        int role=rs.getInt("Role");
                        Users user=new Users(id, firstname, lastname, email, phone, address, role);
                        list.add(user);
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
    
    public Users getUser(String acc_name, String password){
        Users user = null;
        Connection cn = null;
        try {
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT UserID, Email, LastName, Phone, Address, Role, Password\n" +
                    "FROM Users\n" +
                    "WHERE (Email = ? OR Phone = ?) AND Password = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, acc_name);
                pst.setString(2, acc_name);
                pst.setString(3, password);
                ResultSet rst = pst.executeQuery();
                if(rst!=null && rst.next()){
                    if(acc_name.contains("%@%")){
                        user = new Users(
                            rst.getInt("UserID"), 
                            rst.getString("LastName"),
                            acc_name,
                            rst.getString("Phone"), 
                            rst.getString("Address"),
                            rst.getInt("Role"), 
                            password
                        );
                    }else{
                        user = new Users(
                            rst.getInt("UserID"), 
                            rst.getString("LastName"),
                            rst.getString("Email"),
                            acc_name,
                            rst.getString("Address"),
                            rst.getInt("Role"), 
                            password
                        );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(cn!=null) cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return user;
    }
}
