package com.sauravchhabra.udacity.bakingapp.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * A simple class to calculate the number of columns in a given display size
 */
public class ColumnUtils {

    public static int numberOfColumns(Activity activity) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthDivider = 600;
        int width = displayMetrics.widthPixels;
        return width / widthDivider;
    }
}
