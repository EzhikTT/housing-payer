package com.example.godric.housingpayer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
