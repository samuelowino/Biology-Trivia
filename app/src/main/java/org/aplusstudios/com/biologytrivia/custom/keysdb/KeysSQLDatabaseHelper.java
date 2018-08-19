package org.aplusstudios.com.biologytrivia.custom.keysdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class KeysSQLDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NOTES_APP_DATABASE.db";

    public NotesSQLDatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotesDatabaseContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NotesDatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void saveNotesEntry(String index, String title, String content, String dateTime){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE,title);
        contentValues.put(NotesDatabaseContract.NotesEntry.COLUMN_NAME_NOTES_CONTENT,content);
        contentValues.put(NotesDatabaseContract.NotesEntry.COLUMN_NAME_DATE_TIME,dateTime);
        contentValues.put(NotesDatabaseContract.NotesEntry.COLUMN_NAME_ENTRY_INDEX,index);
        long newRowId = db.insert(NotesDatabaseContract.NotesEntry.TABLE_NAME,null,contentValues);

    }

    public List<NotesEntry> getSavedNotesEntries(){

        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                BaseColumns._ID,
                NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE,
                NotesDatabaseContract.NotesEntry.COLUMN_NAME_NOTES_CONTENT,
                NotesDatabaseContract.NotesEntry.COLUMN_NAME_DATE_TIME,
                NotesDatabaseContract.NotesEntry.COLUMN_NAME_ENTRY_INDEX
        };

        String selection = BaseColumns._ID + " > ?";
        String[] selectionArgs = {"-1"};
        String sortOrder = NotesDatabaseContract.NotesEntry.COLUMN_NAME_ENTRY_INDEX + " DESC";

        Cursor cursor  = db.query(
                NotesDatabaseContract.NotesEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List<NotesEntry> notesEntryList = new ArrayList<>();

        while(cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndexOrThrow(NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE));
            String content = cursor.getString(cursor.getColumnIndexOrThrow(NotesDatabaseContract.NotesEntry.COLUMN_NAME_NOTES_CONTENT));
            String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(NotesDatabaseContract.NotesEntry.COLUMN_NAME_DATE_TIME));

            NotesEntry notesEntry = new NotesEntry("Work",title,dateTime,content);
            notesEntryList.add(notesEntry);
        }

        cursor.close();
        return notesEntryList;
    }

    public void deleteNotesEntry(NotesEntry notesEntry) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + NotesDatabaseContract.NotesEntry.TABLE_NAME + " WHERE "+ NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE+ " = '"+ notesEntry.getNotesTitle()+"'");
    }
    // WHERE "+ NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE + " = '"+oldTitle+"'");
    public void updateNotesEntry(String newNotesTitle, String newNotesContent, String oldTitle) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE,newNotesTitle);
        contentValues.put(NotesDatabaseContract.NotesEntry.COLUMN_NAME_NOTES_CONTENT,newNotesContent);

        SQLiteDatabase db = getWritableDatabase();
        db.update(NotesDatabaseContract.NotesEntry.TABLE_NAME,contentValues,NotesDatabaseContract.NotesEntry.COLUMN_NAME_TITLE+" = '"+oldTitle+"'",null);
    }
}

