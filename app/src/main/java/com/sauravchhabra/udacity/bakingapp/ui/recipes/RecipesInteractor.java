package com.sauravchhabra.udacity.bakingapp.ui.recipes;

import com.sauravchhabra.udacity.bakingapp.data.remote.Api;
import com.sauravchhabra.udacity.bakingapp.model.RecipeResponse;
import com.sauravchhabra.udacity.bakingapp.utils.ServerErrorUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RecipesInteractor {

    Api api;

    @Inject
    public RecipesInteractor(Api api) {
        this.api = api;
    }

    public void loadRecipesFromApi(RecipesCallback callback) {
        api.getRecipes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> onSuccess(response, callback),
                        error -> onError(error, callback));
    }

    private void onSuccess(List<RecipeResponse> response, RecipesCallback callback) {
        if (response != null) {
            if (response.size() > 0) {
                callback.onResponse(response);
            } else {
                callback.onRecipeError();
            }
        } else {
            callback.onRecipeError();
        }
    }

    private void onError(Throwable t, RecipesCallback callback) {
        if (ServerErrorUtils.isHttp404(t)) {
            callback.onRecipeError();
        } else if (t.getMessage().equals(ServerErrorUtils.SERVER_ERROR)) {
            callback.onNetworkConnectionError();
        } else {
            callback.onServerError();
        }
    }
}
