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
public class Meals {
    private int MealID;
    private int MenuID;
    private String MealName;
    private String MealDescription;
    private String Type;
    private String Recipe;
    private String Ingredients;
    private String img;

    public Meals() {
    }

    public Meals(int MealID, int MenuID, String MealName, String MealDescription, String Type, String Recipe, String Ingredients, String img) {
        this.MealID = MealID;
        this.MenuID = MenuID;
        this.MealName = MealName;
        this.MealDescription = MealDescription;
        this.Type = Type;
        this.Recipe = Recipe;
        this.Ingredients = Ingredients;
        this.img = img;
    }

    public int getMealID() {
        return MealID;
    }

    public void setMealID(int MealID) {
        this.MealID = MealID;
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int MenuID) {
        this.MenuID = MenuID;
    }

    public String getMealName() {
        return MealName;
    }

    public void setMealName(String MealName) {
        this.MealName = MealName;
    }

    public String getMealDescription() {
        return MealDescription;
    }

    public void setMealDescription(String MealDescription) {
        this.MealDescription = MealDescription;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String Recipe) {
        this.Recipe = Recipe;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String Ingredients) {
        this.Ingredients = Ingredients;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
