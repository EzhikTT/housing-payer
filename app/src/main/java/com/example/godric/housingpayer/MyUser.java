package com.example.godric.housingpayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by godric on 19.05.2016.
 */
public class MyUser extends DataSource {

    private String[] allColumns = {DBHelper.USER_NAME, DBHelper.USER_PASS};

    public MyUser(Context context) {
        super(context);
    }

    public void addUser(String name, String pass) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.USER_NAME, name);
        values.put(DBHelper.USER_PASS, pass);
        long insertId = database.insert(DBHelper.TABLE_USER, null, values);
        close();
    }

    public boolean isLoginAccept(String name, String pass) {
        open();
        Cursor cursor = database.query(DBHelper.TABLE_USER,
                allColumns, null,
                null, null, null, null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast() && cursor.getString(0) == name
                && cursor.getString(1) == pass) {
            return true;
        }
        close();
        return false;
    }
}
