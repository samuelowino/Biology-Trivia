package org.aplusstudios.com.biologytrivia.custom.answersdb;

import android.provider.BaseColumns;

public class AnswersSQLDatabaseContract {

    public static class AnswerEntry implements BaseColumns {

        public static final String TABLE_NAME = "NOTES_ENTRY";
        public static final String COLUMN_ANSWER_ID = "ENTRY_INDEX";
        public static final String COLUMN_ANSWER = "NOTE_ENTRY_TITLE";
        public static final String COLUMN_QUESTION_ID = "CONTENT";
        public static final Boolean COLUMN_IS_CORRECT = false;
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+AnswerEntry.TABLE_NAME + "( "+
                    AnswerEntry._ID + " INTEGER PRIMARY KEY ," +
                    AnswerEntry.COLUMN_ANSWER_ID + " INT,"+
                    AnswerEntry.COLUMN_ANSWER + " TEXT,"+
                    AnswerEntry.COLUMN_QUESTION_ID + " INT,"+
                    AnswerEntry.COLUMN_IS_CORRECT + "TEXT)"; //TODO CONVERT TO BOOLEAN

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS "+AnswerEntry.TABLE_NAME;
}
