package com.example.godric.housingpayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by godric on 18.05.2016.
 */
public class CardDataSource {

    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private ArrayList<Card> cards;

    public CardDataSource(Context context){
        dbHelper = new DBHelper(context);
    }

    public void close() {
        dbHelper.close();
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    
}
