package com.sauravchhabra.udacity.bakingapp.data.local;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;

/**
 * A simple database class
 */
@Database(fileName = BakingDatabase.DB_NAME, version = BakingDatabase.DB_VERSION)
class BakingDatabase {

    static final String DB_NAME = "bakingdb";
    static final int DB_VERSION = 1;

    @Table(BakingContract.class)
    static final String TABLE_NAME = "ingredients";
}
