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
public class RecipeIngredient {
    private int RecipeIngredientID;
    private int RecipeID;
    private int IngredientID;
    private int Amount;

    public RecipeIngredient() {
    }

    public RecipeIngredient(int RecipeIngredientID, int RecipeID, int IngredientID, int Amount) {
        this.RecipeIngredientID = RecipeIngredientID;
        this.RecipeID = RecipeID;
        this.IngredientID = IngredientID;
        this.Amount = Amount;
    }

    public int getRecipeIngredientID() {
        return RecipeIngredientID;
    }

    public void setRecipeIngredientID(int RecipeIngredientID) {
        this.RecipeIngredientID = RecipeIngredientID;
    }

    public int getRecipeID() {
        return RecipeID;
    }

    public void setRecipeID(int RecipeID) {
        this.RecipeID = RecipeID;
    }

    public int getIngredientID() {
        return IngredientID;
    }

    public void setIngredientID(int IngredientID) {
        this.IngredientID = IngredientID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }
    
}
