package org.aplusstudios.com.biologytrivia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import org.aplusstudios.com.biologytrivia.database.coinsdb.CoinsSQLDatabaseContract;
import org.aplusstudios.com.biologytrivia.model.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinsSQLDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BIOLOGY_TRIVIA_DATABASE.db";

    public CoinsSQLDatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CoinsSQLDatabaseContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CoinsSQLDatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void saveLevelsStatus(Integer number,Integer balance,Integer spent){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_TOTAL_NUMBER,number);
        contentValues.put(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_COINS_BALANCE,balance);
        contentValues.put(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_SPENT_COINS,spent);
        long newRowId = db.insert(CoinsSQLDatabaseContract.CoinsEntry.TABLE_NAME,null,contentValues);

    }

    public List<Coin> getSavedLevels(){

        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                BaseColumns._ID,
                CoinsSQLDatabaseContract.CoinsEntry.COLUMN_COINS_BALANCE,
                CoinsSQLDatabaseContract.CoinsEntry.COLUMN_SPENT_COINS,
                CoinsSQLDatabaseContract.CoinsEntry.COLUMN_TOTAL_NUMBER
        };

        String selection = BaseColumns._ID + " > ?";
        String[] selectionArgs = {"-1"};
        String sortOrder = CoinsSQLDatabaseContract.CoinsEntry.COLUMN_TOTAL_NUMBER + " DESC";

        Cursor cursor  = db.query(
                CoinsSQLDatabaseContract.CoinsEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List<Coin> coinList = new ArrayList<>();

        while(cursor.moveToNext()){
            Integer number = cursor.getInt(cursor.getColumnIndexOrThrow(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_TOTAL_NUMBER));
            Integer spent = cursor.getInt(cursor.getColumnIndexOrThrow(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_SPENT_COINS));
            Integer balance = cursor.getInt(cursor.getColumnIndexOrThrow(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_COINS_BALANCE));

            Coin coin = new Coin(number,spent,balance);
            coinList.add(coin);
        }

        cursor.close();
        return coinList;
    }

    // WHERE "+ NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE + " = '"+oldTitle+"'");
    public void updateLevelsStatus(Integer number,Integer balance,Integer spent) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_TOTAL_NUMBER,number);
        contentValues.put(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_COINS_BALANCE,balance);
        contentValues.put(CoinsSQLDatabaseContract.CoinsEntry.COLUMN_COINS_BALANCE,spent);

        SQLiteDatabase db = getWritableDatabase();
        db.update(CoinsSQLDatabaseContract.CoinsEntry.TABLE_NAME,contentValues,
                CoinsSQLDatabaseContract.CoinsEntry.COLUMN_TOTAL_NUMBER+" = '"+number+"'",null);
    }
}


