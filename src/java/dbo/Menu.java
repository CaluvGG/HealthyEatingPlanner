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
public class Menu {
    private int MenuID;
    private String MenuName;
    private String MenuDescription;
    private String imgUrl;

    public Menu() {
    }

    public Menu(int MenuID, String MenuName, String MenuDescription, String imgUrl) {
        this.MenuID = MenuID;
        this.MenuName = MenuName;
        this.MenuDescription = MenuDescription;
        this.imgUrl = imgUrl;
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int MenuID) {
        this.MenuID = MenuID;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String MenuName) {
        this.MenuName = MenuName;
    }

    public String getMenuDescription() {
        return MenuDescription;
    }

    public void setMenuDescription(String MenuDescription) {
        this.MenuDescription = MenuDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
