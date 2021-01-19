package com.example.lab1pc19.sti_stf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class accountingskedhelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "accountingsked.db";
    public static final String TABLE_NAME = "tablesked";
    public static final String COL_1 = "requestid";
    public static final String COL_2 = "student";
    public static final String COL_3 = "tutor";
    public static final String COL_4 = "status";

    public accountingskedhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (requestid INTEGER PRIMARY KEY AUTOINCREMENT, student TEXT, tutor TEXT, status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " +TABLE_NAME);
        onCreate(db);
    }

    public boolean hanapngbago(
            String student,
            String tutor,
            String status
    )
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, student);
        contentValues.put(COL_3, tutor);
        contentValues.put(COL_4, status);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    //

    public Cursor gehtignanmoulet() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT *FROM " + TABLE_NAME, null);
        return res;
    }

    /*
autoincrementid
student
tutor
subject
schedule
availability
    */

    public boolean humanapngpamalit (String requestid, String status) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,requestid);
        contentValues.put(COL_4,status);
        db.update(TABLE_NAME, contentValues, "requestid = ?", new String[] {requestid});
        return true;
    }






}
