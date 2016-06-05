package com.example.godric.housingpayer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public static final String TABLE_SERVICES = "services";
    public static final String SERVICE_NAME = "name";
    public static final String SERVICE_DESCR = "descr";
    public static final String SERVICE_PRICE = "price";
    public static final String SERVICE_PERIOD = "period";

    public static final String TABLE_PERIOD = "periods";
    public static final String PERIOD_STARTING = "start";
    public static final String PERIOD_ENDING = "end";
    public static final String PERIOD_VALUE = "value";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CARD + " ( "
                + ID + " integer primary key, "
                + CARD_NUMBER + " text unique, "
                + CARD_YEAR + " integer, "
                + CARD_OWNER + " text "
                + ");" );
        db.execSQL("create table " + TABLE_USER + " ( "
                + ID + " integer primary key, "
                + USER_NAME + " text unique, "
                + USER_PASS + " text "
                + ");" );
        db.execSQL("create table " + TABLE_SERVICES + " ( "
                + ID + " integer primary key, "
                + SERVICE_NAME  + " text unique, "
                + SERVICE_PRICE + " int, "
                + SERVICE_PERIOD + " text "
                + ");" );
        db.execSQL("create table " + TABLE_PERIOD + " ( "
                + ID + " integer primary key, "
                + PERIOD_STARTING + " text, "
                + PERIOD_ENDING + " text, "
                + PERIOD_VALUE + " int "
                + ");" );

        db.execSQL("insert into " + TABLE_SERVICES + "("
                + SERVICE_NAME + ", " + SERVICE_PRICE + ", " + SERVICE_PERIOD + ") "
                + " values ("
                + "\'Gas\', 23, NULL"
                + ");");
        db.execSQL("insert into " + TABLE_SERVICES + "("
                + SERVICE_NAME + ", " + SERVICE_PRICE + ", " + SERVICE_PERIOD + ") "
                + " values ("
                + "\'Electric\', 30, NULL"
                + ");");
        db.execSQL("insert into " + TABLE_SERVICES + "("
                + SERVICE_NAME + ", " + SERVICE_PRICE + ", " + SERVICE_PERIOD + ") "
                + " values ("
                + "\'House\', 43, NULL"
                + ");");
        db.execSQL("insert into " + TABLE_SERVICES + "("
                + SERVICE_NAME + ", " + SERVICE_PRICE + ", " + SERVICE_PERIOD + ") "
                + " values ("
                + "\'Water\', 29, NULL"
                + ");");
        db.execSQL("insert into " + TABLE_SERVICES + "("
                + SERVICE_NAME + ", " + SERVICE_PRICE + ", " + SERVICE_PERIOD + ") "
                + " values ("
                + "\'Heating\', 29, NULL"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CARD);
        onCreate(db);
    }
}
