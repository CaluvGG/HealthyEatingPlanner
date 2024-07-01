
package dbo;

public class WeeklyMenus {
    private int MenuID;
    private String MenyName;
    private String Description;

    public WeeklyMenus() {
    }

    public WeeklyMenus(int MenuID, String MenyName) {
        this.MenuID = MenuID;
        this.MenyName = MenyName;
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int MenuID) {
        this.MenuID = MenuID;
    }

    public String getMenyName() {
        return MenyName;
    }

    public void setMenyName(String MenyName) {
        this.MenyName = MenyName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
