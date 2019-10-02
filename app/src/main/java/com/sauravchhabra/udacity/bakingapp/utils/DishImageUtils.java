package com.sauravchhabra.udacity.bakingapp.utils;

import com.sauravchhabra.udacity.bakingapp.R;

/**
 * A simple class to get the image resource
 */
public class DishImageUtils {

    public static int getRecipeImg(int id) {
        int drawable;
        switch (id) {
            case 1:
                drawable = R.drawable.nutella_pie;
                break;
            case 2:
                drawable = R.drawable.brownies;
                break;
            case 3:
                drawable = R.drawable.yellow_cake;
                break;
            case 4:
                drawable = R.drawable.cheesecake;
                break;
            default:
                drawable = R.mipmap.ic_launcher;
        }

        return drawable;
    }
}
