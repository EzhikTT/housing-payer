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

    public static final String TABLE_CARD = "card";
    public static final String CARD_NUMBER = "number";
    public static final String CARD_YEAR = "year";
    public static final String CARD_OWNER = "owner";

    public static final String TABLE_HOUSES = "house";
    public static final String HOUSE_FLOOR = "flooramount";
    public static final String HOUSE_DOOR = "dooramount";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CARD + " ( "
                + ID + " integer primary key, "
                + CARD_NUMBER + " text "
                + CARD_YEAR + " integer "
                + CARD_OWNER + " text "
                + ");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CARD);

        onCreate(db);
    }
}
