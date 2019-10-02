package com.sauravchhabra.udacity.bakingapp.di;

import android.app.Application;
import android.content.Context;

import com.sauravchhabra.udacity.bakingapp.BuildConfig;
import com.sauravchhabra.udacity.bakingapp.data.remote.Api;
import com.sauravchhabra.udacity.bakingapp.ui.detail.RecipeDetailFragment;
import com.sauravchhabra.udacity.bakingapp.ui.detail.RecipeDetailInteractor;
import com.sauravchhabra.udacity.bakingapp.ui.detail.RecipeDetailPresenter;
import com.sauravchhabra.udacity.bakingapp.ui.detail.RecipeDetailView;
import com.sauravchhabra.udacity.bakingapp.ui.recipes.RecipeListFragment;
import com.sauravchhabra.udacity.bakingapp.ui.recipes.RecipesInteractor;
import com.sauravchhabra.udacity.bakingapp.ui.recipes.RecipesMvpView;
import com.sauravchhabra.udacity.bakingapp.ui.recipes.RecipesPresenter;
import com.sauravchhabra.udacity.bakingapp.utils.ConstantsUtils;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple class to inject the dependency framework using dagger
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            okHttpClient.addNetworkInterceptor(new StethoInterceptor());
            okHttpClient.addInterceptor(httpLoggingInterceptor);
        }
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    Api provideApiSource(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsUtils.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(Api.class);
    }

    @Provides
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    RecipesMvpView provideRecipesMvpView() {
        return new RecipeListFragment();
    }

    @Provides
    RecipesInteractor provideRecipesInteractor(Api api) {
        return new RecipesInteractor(api);
    }

    @Provides
    RecipesPresenter provideRecipesPresenter(RecipesMvpView view, RecipesInteractor interactor) {
        return new RecipesPresenter(view, interactor);
    }

    @Provides
    RecipeDetailView provideRecipeDetailView() {
        return new RecipeDetailFragment();
    }

    @Provides
    RecipeDetailInteractor provideRecipeDetailInteractor(Context context) {
        return new RecipeDetailInteractor(context);
    }

    @Provides
    RecipeDetailPresenter provideRecipeDetailPresenter(RecipeDetailView view, RecipeDetailInteractor interactor) {
        return new RecipeDetailPresenter(view, interactor);
    }

}
