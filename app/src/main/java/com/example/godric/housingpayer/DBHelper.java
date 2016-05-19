package com.example.godric.housingpayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by godric on 18.05.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TestingData";

    public static final String ID = "_id";

    public static final String TABLE_CARD = "cards";
    public static final String CARD_NUMBER = "number";
    public static final String CARD_YEAR = "year";
    public static final String CARD_OWNER = "owner";

    public static final String TABLE_HOUSES = "houses";
    public static final String HOUSE_FLOOR = "flooramount";
    public static final String HOUSE_DOOR = "dooramount";

    public static final String TABLE_USER = "users";
    public static final String USER_NAME = "name";
    public static final String USER_PASS = "pass";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CARD + " ( "
                + ID + " integer primary key, "
                + CARD_NUMBER + " text, "
                + CARD_YEAR + " integer, "
                + CARD_OWNER + " text "
                + ");" );
        db.execSQL("create table " + TABLE_USER + " ( "
                + ID + " integer primary key, "
                + USER_NAME + " text, "
                + USER_PASS + " text "
                + ");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CARD);
        onCreate(db);
    }
}
