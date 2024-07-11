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
                    if(acc_name.contains("@")){
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
    
    public int addUser(String FirstName, String LastName, String Email, String Phone, String Address, int Role, String Password){
        int add_acc = 0;
        Connection cn = null;
        try {
            cn =DBUtil.makeConnection();
            if(cn!=null){
                String sql ="insert Users(FirstName,LastName,Email,Phone,Address,Role,Password) "
                        + "values(?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, FirstName);
                pst.setString(2, LastName);
                pst.setString(3, Email);
                pst.setString(4, Phone);
                pst.setString(5, Address);
                pst.setInt(6, Role);
                pst.setString(7, Password);
                
                add_acc=pst.executeUpdate();
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
        return add_acc;
    }

    public Users getUserEmail(String email_user) {
        Users acc = null;
        Connection cn = null;
         try {
            cn =DBUtil.makeConnection();
            if(cn!=null){
                String sql ="select * from Users where Email=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email_user);
                ResultSet rst = pst.executeQuery();
                if(rst!=null && rst.next()){
                    acc = new Users(rst.getInt("UserID"),
                            rst.getString("FirstName"),
                            rst.getString("LastName"),
                            rst.getString("Email"),
                            rst.getString("Phone"),
                            rst.getString("Address"),
                            rst.getInt("Role"));
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
        return acc;
    }
    public Users getUser(int userID) {
        Users user=null;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "SELECT [UserID],[FirstName],[LastName],[Email],[Phone],[Address],[Role],[Password]\n"
                        + "FROM [dbo].[Users]\n"
                        + "WHERE [UserID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setInt(1, userID);
                ResultSet rs=pst.executeQuery(sql);
                if(rs!=null){
                    while(rs.next()){
                        String fname=rs.getString("FirstName");
                        String lname=rs.getString("LastName");
                        String email=rs.getString("Email");
                        String phone=rs.getString("Phone");
                        String address=rs.getString("Address");
                        int role=rs.getInt("Role");
                        String pass=rs.getString("Password");
                        user=new Users(userID, fname, lname, email, phone, address, role);
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
        return user;
    }
    
    public int UpdateUser(String fname, String lname, String email, String phone, String address, int role, String pass, int id){
        int rs=0;
        Connection cn=null;
        try{
            cn=DBUtil.makeConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[Users]\n"
                        + "SET [FirstName]=?,[LastName]=?,[Email]=?,[Phone]=?,[Address]=?,[Role]=?,[Password]=?\n"
                        + "WHERE [UserID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, email);
                pst.setString(4, phone);
                pst.setString(5, address);
                pst.setInt(6, role);
                pst.setString(7, pass);
                pst.setInt(8, id);
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
