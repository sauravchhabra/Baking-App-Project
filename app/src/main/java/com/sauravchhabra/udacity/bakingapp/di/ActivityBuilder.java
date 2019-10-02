package com.sauravchhabra.udacity.bakingapp.di;

import com.sauravchhabra.udacity.bakingapp.ui.detail.RecipeDetailActivity;
import com.sauravchhabra.udacity.bakingapp.ui.recipes.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * A simple class for dependency framework
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = FragmentBuilder.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = FragmentBuilder.class)
    abstract RecipeDetailActivity recipeDetailActivity();
}
