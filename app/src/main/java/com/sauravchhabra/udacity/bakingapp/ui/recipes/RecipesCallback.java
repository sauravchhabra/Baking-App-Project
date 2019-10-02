package com.sauravchhabra.udacity.bakingapp.ui.recipes;

import com.sauravchhabra.udacity.bakingapp.base.BaseCallback;
import com.sauravchhabra.udacity.bakingapp.model.RecipeResponse;

import java.util.List;

public interface RecipesCallback extends BaseCallback {

    void onResponse(List<RecipeResponse> recipeList);

    void onRecipeError();
}
