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
public class Recipes {
    private int RecipeID;
    private int MenuID;
    private String RecipeName;
    private String Instructions;

    public Recipes() {
    }

    public Recipes(int RecipeID, int MenuID, String RecipeName, String Instructions) {
        this.RecipeID = RecipeID;
        this.MenuID = MenuID;
        this.RecipeName = RecipeName;
        this.Instructions = Instructions;
    }

    public int getRecipeID() {
        return RecipeID;
    }

    public void setRecipeID(int RecipeID) {
        this.RecipeID = RecipeID;
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int MenuID) {
        this.MenuID = MenuID;
    }

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String RecipeName) {
        this.RecipeName = RecipeName;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String Instructions) {
        this.Instructions = Instructions;
    }
    
}
