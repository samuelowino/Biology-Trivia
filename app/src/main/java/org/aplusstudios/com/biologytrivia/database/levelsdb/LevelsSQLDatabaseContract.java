package org.aplusstudios.com.biologytrivia.database.levelsdb;

import android.provider.BaseColumns;

public class LevelsSQLDatabaseContract {

    public static class LevelsEntry implements BaseColumns {
        public static final String TABLE_NAME = "LEVELS_ENTRY";
        public static final String COLUMN_LEVEL_NUMBER = "LEVEL_NUMBER";
        public static final String COLUMN_LEVEL_STARTED = "LEVEL_STARTED";
        public static final String COLUMN_LEVEL_COMPLETED = "LEVEL_COMPLETED";
        public static final String COLUMN_LEVEL_TITLE = "LEVEL_TITLE";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+LevelsEntry.TABLE_NAME + "( "+
                    LevelsEntry._ID + " INTEGER PRIMARY KEY ," +
                    LevelsEntry.COLUMN_LEVEL_NUMBER + " INT,"+
                    LevelsEntry.COLUMN_LEVEL_STARTED + " INT,"+
                    LevelsEntry.COLUMN_LEVEL_COMPLETED + " INT,"+
                    LevelsEntry.COLUMN_LEVEL_TITLE + " TEXT )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS "+LevelsEntry.TABLE_NAME;
}
