package com.sauravchhabra.udacity.bakingapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * A simple class which implements serializable to save the data
 */
public class Ingredient implements Serializable {
    @SerializedName("quantity")
    private double quantity;

    @SerializedName("measure")
    private String measure;

    @SerializedName("ingredient")
    private String ingredient;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
