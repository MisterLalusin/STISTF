package com.example.lab1pc19.sti_stf;

/**
 * Created by lab1pc19 on 2/2/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="STITF.db";
    public static final String TABLE_NAME="registration";
    public static final String COL_1="ID";
    public static final String COL_2="STUDENT_ID_NO";
    public static final String COL_3="LastName";
    public static final String COL_4="FirstName";
    public static final String COL_5="MiddleName";
    public static final String COL_6="Program";
    public static final String COL_7="YearLevel";
    public static final String COL_8="ContactNumber";
    public static final String COL_9="Username";
    public static final String COL_10="Password";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE registration (ID INTEGER PRIMARY KEY AUTOINCREMENT ,STUDENTIDNO TEXT ,LastName TEXT ,FirstName TEXT ,MiddleName TEXT ,Program TEXT ,YearLevel TEXT ,Contact TEXT ,Username TEXT ,Password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS registration");
        onCreate(db);
    }

}
