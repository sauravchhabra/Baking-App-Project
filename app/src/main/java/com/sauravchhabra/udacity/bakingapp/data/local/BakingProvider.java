package com.sauravchhabra.udacity.bakingapp.data.local;


import android.net.Uri;

import net.simonvt.schematic.annotation.ContentProvider;
import net.simonvt.schematic.annotation.ContentUri;
import net.simonvt.schematic.annotation.TableEndpoint;

/**
 * A simple content provider class to connect to local database
 */
@ContentProvider(authority = BakingProvider.AUTHORITY, database = BakingDatabase.class)
public class BakingProvider {

    static final String AUTHORITY = "com.sauravchhabra.udacity.bakingapp.local.provider";

    @TableEndpoint(table = BakingDatabase.TABLE_NAME)
    public static class RecipeIngredients {

        @ContentUri(path = "ingredients", type = "vnd.android.cursor.dir/ingredients")
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/ingredients");
    }
}
