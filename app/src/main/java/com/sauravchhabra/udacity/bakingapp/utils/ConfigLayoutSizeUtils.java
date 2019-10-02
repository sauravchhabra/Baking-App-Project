package com.sauravchhabra.udacity.bakingapp.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * A simple class to check if the running device is either tablet or in landscape mode
 */
public class ConfigLayoutSizeUtils {
    public static boolean isTabletMode(Context context) {
        return (context.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

    public static boolean isLandScape(Context context) {
        return Configuration.ORIENTATION_LANDSCAPE == context.getResources().getConfiguration().orientation;
    }
}
