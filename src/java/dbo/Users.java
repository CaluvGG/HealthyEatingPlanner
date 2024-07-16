/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

/**
 *
 * @author user
 */
public class Users {
    private int UserID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    private String Address;
    private int Role;
    private String Password;

    public Users() {
    }

    public Users(int UserID, String LastName, String Email, String Phone, String Address, int Role, String Password) {
        this.UserID = UserID;
        this.LastName = LastName;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
        this.Role = Role;
        this.Password = Password;
    }

    public Users(int id, String firstname, String lastname, String email, String phone, String address, int role) {
        this.UserID = id;
        this.FirstName = firstname;
        this.LastName = lastname;
        this.Email = email;
        this.Phone = phone;
        this.Address = address;
        this.Role = role;
    }
    public Users(int id, String firstname, String lastname, String email, String phone, String address, int role, String Password) {
        this.UserID = id;
        this.FirstName = firstname;
        this.LastName = lastname;
        this.Email = email;
        this.Phone = phone;
        this.Address = address;
        this.Role = role;
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastNam) {
        this.LastName = LastNam;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }
    
    
}
