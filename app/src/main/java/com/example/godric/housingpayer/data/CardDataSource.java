package com.example.godric.housingpayer.data;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.godric.housingpayer.essence.Card;

/**
 * Created by godric on 18.05.2016.
 */
public class CardDataSource extends DataSource {

    private String[] allColumns = { DBHelper.ID,
            DBHelper.CARD_NUMBER, DBHelper.CARD_YEAR, DBHelper.CARD_OWNER};

    public CardDataSource(Context context) {
        super(context);
    }

    public boolean createCard(String number, int year, String owner) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.CARD_NUMBER, number);
        values.put(DBHelper.CARD_YEAR, year);
        values.put(DBHelper.CARD_OWNER, owner);

        long insertId = database.insert(DBHelper.TABLE_CARD, null, values);
        if (insertId == -1) {
            close();
            return false;
        }
        return true;
    }

    public Card getCardByNumber(String number) {
        open();
        Cursor cursor = database.query(DBHelper.TABLE_CARD,
                allColumns, DBHelper.CARD_NUMBER + "=?",
                new String[]{number}, null, null, null);
        if (cursor.getCount() == 0) {
            cursor.close();
            close();
            return null;
        }
        cursor.moveToFirst();
        Card res = new Card(cursor.getInt(0), cursor.getString(1),
                                cursor.getInt(2), cursor.getString(3));
        cursor.close();
        close();
        return res;
    }

    public ArrayList<Card> getAllCards() {
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
