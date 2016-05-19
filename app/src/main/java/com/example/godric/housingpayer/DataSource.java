package com.example.godric.housingpayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by godric on 19.05.2016.
 */
public class DataSource {
    protected SQLiteDatabase database;
    protected DBHelper dbHelper;

    public DataSource(Context context){
        dbHelper = new DBHelper(context);
    }

    public void close() {
        dbHelper.close();
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }


}
