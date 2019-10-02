package com.sauravchhabra.udacity.bakingapp.ui.detail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.sauravchhabra.udacity.bakingapp.R;
import com.sauravchhabra.udacity.bakingapp.base.BaseActivity;
import com.sauravchhabra.udacity.bakingapp.model.RecipeResponse;
import com.sauravchhabra.udacity.bakingapp.utils.ConstantsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailActivity extends BaseActivity {

    @BindView(R.id.recipe_detail_toolbar)
    Toolbar detailToolbar;

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

        RecipeResponse response = (RecipeResponse) getIntent().getExtras().getSerializable(ConstantsUtils.RECIPES_EXTRA);

        setupToolbar(response);

        if (savedInstanceState == null) {
            if (findViewById(R.id.steps_container) != null) {
                mTwoPane = true;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.recipeDetailContainer, RecipeDetailFragment.newInstance(response))
                        .commit();
            } else {
                mTwoPane = false;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.recipeDetailContainer, RecipeDetailFragment.newInstance(response))
                        .commit();
            }
        }
    }

    private void setupToolbar(RecipeResponse response) {
        setSupportActionBar(detailToolbar);
        getSupportActionBar().setTitle(response.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
