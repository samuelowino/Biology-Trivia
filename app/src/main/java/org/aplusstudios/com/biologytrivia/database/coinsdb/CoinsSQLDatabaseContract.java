package org.aplusstudios.com.biologytrivia.database.coinsdb;

import android.provider.BaseColumns;

public class CoinsSQLDatabaseContract {

    public static class CoinsEntry implements BaseColumns {
        public static final String TABLE_NAME = "COINS_ENTRY";
        public static final String COLUMN_TOTAL_NUMBER = "TOTAL_NUMBER";
        public static final String COLUMN_SPENT_COINS = "SPENT_COINS";
        public static final String COLUMN_COINS_BALANCE = "COINS_BALANCE";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+CoinsEntry.TABLE_NAME + "( "+
                    CoinsEntry._ID + " INTEGER PRIMARY KEY ," +
                    CoinsEntry.COLUMN_TOTAL_NUMBER + " INT,"+
                    CoinsEntry.COLUMN_SPENT_COINS + " INT,"+
                    CoinsEntry.COLUMN_COINS_BALANCE + " INT )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS "+CoinsEntry.TABLE_NAME;
}
