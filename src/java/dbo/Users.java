
package dbo;

import java.sql.Date;

public class Users {
    private int UserID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    private String PasswordHash;
    private Date CreatedAt;

    public Users(int UserID, String PasswordHash, Date CreatedAt) {
        this.UserID = UserID;
        this.PasswordHash = PasswordHash;
        this.CreatedAt = CreatedAt;
    }

    public Users() {
    }

    public int getUserID() {
        return UserID;
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

    public void setLastName(String LastName) {
        this.LastName = LastName;
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

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }
    
    
}
