package org.aplusstudios.com.biologytrivia.custom.answersdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class AnswersSQLDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NOTES_APP_DATABASE.db";

    public AnswersSQLDatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AnswersSQLDatabaseContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AnswersSQLDatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void saveAnswer(String index, String title, String content, String dateTime){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_TITLE,title);
        contentValues.put(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_NOTES_CONTENT,content);
        contentValues.put(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_DATE_TIME,dateTime);
        contentValues.put(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_ENTRY_INDEX,index);
        long newRowId = db.insert(AnswersSQLDatabaseContract.AnswerEntry.TABLE_NAME,null,contentValues);

    }

    public List<AnswersSQLDatabaseContract.AnswerEntry> getSavedNotesEntries(){

        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                BaseColumns._ID,
                AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_TITLE,
                AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_NOTES_CONTENT,
                AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_DATE_TIME,
                AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_ENTRY_INDEX
        };

        String selection = BaseColumns._ID + " > ?";
        String[] selectionArgs = {"-1"};
        String sortOrder = AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_ENTRY_INDEX + " DESC";

        Cursor cursor  = db.query(
                AnswersSQLDatabaseContract.AnswerEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List<AnswersSQLDatabaseContract.AnswerEntry> AnswerList = new ArrayList<>();

        while(cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndexOrThrow(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_TITLE));
            String content = cursor.getString(cursor.getColumnIndexOrThrow(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_NOTES_CONTENT));
            String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_DATE_TIME));

            AnswersSQLDatabaseContract.AnswerEntry AnswerEntry = new AnswerEntry("Work",title,dateTime,content);
            AnswerList.add(AnswerEntry);
        }

        cursor.close();
        return AnswerList;
    }

    public void deleteAnswer(AnswersSQLDatabaseContract.AnswerEntry AnswerEntry) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + AnswersSQLDatabaseContract.AnswerEntry.TABLE_NAME + " WHERE "+ AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_TITLE+ " = '"+ AnswerEntry.getNotesTitle()+"'");
    }
    // WHERE "+ AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_TITLE + " = '"+oldTitle+"'");
    public void updateAnswer(String newNotesTitle, String newNotesContent, String oldTitle) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_TITLE,newNotesTitle);
        contentValues.put(AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_NOTES_CONTENT,newNotesContent);

        SQLiteDatabase db = getWritableDatabase();
        db.update(AnswersSQLDatabaseContract.AnswerEntry.TABLE_NAME,contentValues,AnswersSQLDatabaseContract.AnswerEntry.COLUMN_NAME_TITLE+" = '"+oldTitle+"'",null);
    }
}

