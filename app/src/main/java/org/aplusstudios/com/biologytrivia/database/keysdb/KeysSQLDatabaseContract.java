package org.aplusstudios.com.biologytrivia.database.keysdb;

import android.provider.BaseColumns;

public class KeysSQLDatabaseContract {

    public static class KeysEntry implements BaseColumns {
        public static final String TABLE_NAME = "KEYS_ENTRY";
        public static final String COLUMN_TOTAL_NUMBER = "ENTRY_INDEX";
        public static final String COLUMN_USED_KEYS = "NOTE_ENTRY_TITLE";
        public static final String COLUMN_KEYS_BALANCE = "CONTENT";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+KeysEntry.TABLE_NAME + "( "+
                    KeysEntry._ID + " INTEGER PRIMARY KEY ," +
                    KeysEntry.COLUMN_TOTAL_NUMBER + " INT,"+
                    KeysEntry.COLUMN_USED_KEYS + " INT,"+
                    KeysEntry.COLUMN_KEYS_BALANCE + " INT )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS "+KeysEntry.TABLE_NAME;
}
