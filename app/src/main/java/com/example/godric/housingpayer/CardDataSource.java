package com.example.godric.housingpayer;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by godric on 18.05.2016.
 */
public class CardDataSource extends DataSource {

    private String[] allColumns = { DBHelper.ID,
            DBHelper.CARD_NUMBER, DBHelper.CARD_YEAR, DBHelper.CARD_OWNER};

    public CardDataSource(Context context) {
        super(context);
    }

    public Card createCard(String number, int year, String owner) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.CARD_NUMBER, number);
        values.put(DBHelper.CARD_YEAR, year);
        values.put(DBHelper.CARD_OWNER, owner);

        long insertId = database.insert(DBHelper.TABLE_CARD, null, values);

        Cursor cursor = database.query(DBHelper.TABLE_CARD,
                allColumns, DBHelper.ID + " = " + insertId,
                null, null, null, null);
        cursor.moveToFirst();
        Card res = new Card(cursor.getInt(0), number, year, owner);
        cursor.close();
        close();
        return res;
    }

    public ArrayList<Card> getAllComments() {
        open();
        ArrayList<Card> cards = new ArrayList<Card>();

        Cursor cursor = database.query(DBHelper.TABLE_CARD,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cards.add(new Card(cursor.getInt(0),
                    cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return cards;
    }
    
}
