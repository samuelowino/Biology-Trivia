package org.aplusstudios.com.biologytrivia.custom.levelsdb;

import android.provider.BaseColumns;

public class LevelsSQLDatabaseContract {

    public static class NotesEntry implements BaseColumns {
        public static final String TABLE_NAME = "NOTES_ENTRY";
        public static final String COLUMN_NAME_ENTRY_INDEX = "ENTRY_INDEX";
        public static final String COLUMN_NAME_TITLE = "NOTE_ENTRY_TITLE";
        public static final String COLUMN_NAME_NOTES_CONTENT = "CONTENT";
        public static final String COLUMN_NAME_DATE_TIME = "DATE_TIME";
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+NotesEntry.TABLE_NAME + "( "+
                    NotesEntry._ID + " INTEGER PRIMARY KEY ," +
                    NotesEntry.COLUMN_NAME_ENTRY_INDEX + " TEXT,"+
                    NotesEntry.COLUMN_NAME_TITLE + " TEXT,"+
                    NotesEntry.COLUMN_NAME_NOTES_CONTENT + " TEXT,"+
                    NotesEntry.COLUMN_NAME_DATE_TIME + " TEXT )";

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS "+NotesEntry.TABLE_NAME;
}
