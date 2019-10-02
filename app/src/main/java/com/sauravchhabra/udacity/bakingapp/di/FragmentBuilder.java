package com.sauravchhabra.udacity.bakingapp.di;

import com.sauravchhabra.udacity.bakingapp.ui.detail.RecipeDetailFragment;
import com.sauravchhabra.udacity.bakingapp.ui.recipes.RecipeListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * A simple class for dependency framework
 */
@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract RecipeListFragment contributeRecipeListFragment();

    @ContributesAndroidInjector
    abstract RecipeDetailFragment contributeRecipeDetailFragment();
}
