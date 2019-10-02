package com.sauravchhabra.udacity.bakingapp.ui.recipes;

import com.sauravchhabra.udacity.bakingapp.base.MvpView;
import com.sauravchhabra.udacity.bakingapp.model.RecipeResponse;

import java.util.List;

public interface RecipesMvpView extends MvpView {

    void renderRecipes(List<RecipeResponse> recipesList);
}
