package com.sauravchhabra.udacity.bakingapp.data.remote;

import com.sauravchhabra.udacity.bakingapp.model.RecipeResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * A simple interface to connect to online database
 */
public interface Api {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Single<List<RecipeResponse>> getRecipes();
}
