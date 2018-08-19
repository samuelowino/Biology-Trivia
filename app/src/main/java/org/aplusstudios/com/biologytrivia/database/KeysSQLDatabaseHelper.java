package org.aplusstudios.com.biologytrivia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import org.aplusstudios.com.biologytrivia.database.keysdb.KeysSQLDatabaseContract;
import org.aplusstudios.com.biologytrivia.model.Key;

import java.util.ArrayList;
import java.util.List;

public class KeysSQLDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BIOLOGY_TRIVIA_DATABASE.db";

    public KeysSQLDatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(KeysSQLDatabaseContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(KeysSQLDatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void saveLevelsStatus(Integer number,Integer used,Integer balance){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KeysSQLDatabaseContract.KeysEntry.COLUMN_TOTAL_NUMBER,number);
        contentValues.put(KeysSQLDatabaseContract.KeysEntry.COLUMN_USED_KEYS,used);
        contentValues.put(KeysSQLDatabaseContract.KeysEntry.COLUMN_KEYS_BALANCE,balance);
        long newRowId = db.insert(KeysSQLDatabaseContract.KeysEntry.TABLE_NAME,null,contentValues);

    }

    public List<Key> getSavedLevels(){

        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                BaseColumns._ID,
                KeysSQLDatabaseContract.KeysEntry.COLUMN_TOTAL_NUMBER,
                KeysSQLDatabaseContract.KeysEntry.COLUMN_USED_KEYS,
                KeysSQLDatabaseContract.KeysEntry.COLUMN_KEYS_BALANCE
        };

        String selection = BaseColumns._ID + " > ?";
        String[] selectionArgs = {"-1"};
        String sortOrder = KeysSQLDatabaseContract.KeysEntry.COLUMN_TOTAL_NUMBER + " DESC";

        Cursor cursor  = db.query(
                KeysSQLDatabaseContract.KeysEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List<Key> keyList = new ArrayList<>();

        while(cursor.moveToNext()){
            Integer number = cursor.getInt(cursor.getColumnIndexOrThrow(KeysSQLDatabaseContract.KeysEntry.COLUMN_TOTAL_NUMBER));
            Integer usedKeys = cursor.getInt(cursor.getColumnIndexOrThrow(KeysSQLDatabaseContract.KeysEntry.COLUMN_USED_KEYS));
            Integer balance = cursor.getInt(cursor.getColumnIndexOrThrow(KeysSQLDatabaseContract.KeysEntry.COLUMN_KEYS_BALANCE));

            Key key = new Key(number,usedKeys,balance);
            keyList.add(key);
        }

        cursor.close();
        return keyList;
    }

    public void updateLevelsStatus(Integer number,Integer used,Integer balance) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(KeysSQLDatabaseContract.KeysEntry.COLUMN_KEYS_BALANCE,balance);
        contentValues.put(KeysSQLDatabaseContract.KeysEntry.COLUMN_USED_KEYS,used);
        contentValues.put(KeysSQLDatabaseContract.KeysEntry.COLUMN_USED_KEYS,balance);



        SQLiteDatabase db = getWritableDatabase();
        db.update(KeysSQLDatabaseContract.KeysEntry.TABLE_NAME,contentValues,
                KeysSQLDatabaseContract.KeysEntry.COLUMN_TOTAL_NUMBER+" = '"+number+"'",null);
    }
}


