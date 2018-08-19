package org.aplusstudios.com.biologytrivia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import org.aplusstudios.com.biologytrivia.database.levelsdb.LevelsSQLDatabaseContract;
import org.aplusstudios.com.biologytrivia.model.Level;

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
        db.execSQL(LevelsSQLDatabaseContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(LevelsSQLDatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void saveLevelsStatus(String title,Boolean isStarted,String levelNumber,Boolean isCompleted){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_TITLE,title);
        contentValues.put(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_STARTED,isStarted.toString());
        contentValues.put(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_NUMBER,levelNumber);
        contentValues.put(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_COMPLETED,isCompleted.toString());
        long newRowId = db.insert(LevelsSQLDatabaseContract.LevelsEntry.TABLE_NAME,null,contentValues);

    }

    public List<Level> getSavedLevels(){

        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                BaseColumns._ID,
                LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_TITLE,
                LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_STARTED,
                LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_NUMBER,
                LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_COMPLETED
        };

        String selection = BaseColumns._ID + " > ?";
        String[] selectionArgs = {"-1"};
        String sortOrder = LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_TITLE + " DESC";

        Cursor cursor  = db.query(
                LevelsSQLDatabaseContract.LevelsEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List<Level> notesEntryList = new ArrayList<>();

        while(cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndexOrThrow(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_TITLE));
            Integer number = cursor.getInt(cursor.getColumnIndexOrThrow(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_NUMBER));
            Integer started = cursor.getInt(cursor.getColumnIndexOrThrow(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_STARTED));
            Integer complete = cursor.getInt(cursor.getColumnIndexOrThrow(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_COMPLETED));

            Boolean isStarted = false;
            Boolean isCompleted = false;

            if (started == 1)
                isStarted = true;

            if (complete == 1)
                isCompleted = true;

            Level notesEntry = new Level(number,isStarted,isCompleted,title);
            notesEntryList.add(notesEntry);
        }

        cursor.close();
        return notesEntryList;
    }

    // WHERE "+ NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE + " = '"+oldTitle+"'");
    public void updateLevelsStatus(int number, boolean isStarted, boolean isCompleted, String levelTitle) {

        int completed = 0;
        int started = 0;

        if (isCompleted)
            completed = 1;

        if (isStarted)
            started = 1;

        ContentValues contentValues = new ContentValues();
        contentValues.put(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_COMPLETED,started);
        contentValues.put(LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_STARTED,completed);


        SQLiteDatabase db = getWritableDatabase();
        db.update(LevelsSQLDatabaseContract.LevelsEntry.TABLE_NAME,contentValues,
                LevelsSQLDatabaseContract.LevelsEntry.COLUMN_LEVEL_NUMBER+" = '"+number+"'",null);
    }
}


