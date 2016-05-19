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

    public boolean addUser(String name, String pass) {
        open();
        Cursor cursor = database.query(DBHelper.TABLE_USER,
                allColumns, DBHelper.USER_NAME + "=?",
                new String[]{name}, null, null, null);
        if (cursor == null) {
            close();
            return false;
        }
        ContentValues values = new ContentValues();
        values.put(DBHelper.USER_NAME, name);
        values.put(DBHelper.USER_PASS, pass);
        long insertId = database.insert(DBHelper.TABLE_USER, null, values);
        close();
        return true;
    }

    public boolean isLoginAccept(String name, String pass) {
        open();
        Cursor cursor = database.query(DBHelper.TABLE_USER,
                allColumns, DBHelper.USER_NAME + "=?",
                new String[]{name}, null, null, null);
        if (cursor == null) {
            return false;
        }
        cursor.moveToFirst();
        String x1 = cursor.getString(0);
        String x2 = cursor.getString(1);
        if (name.equals(cursor.getString(0)) && pass.equals(cursor.getString(1))) {
            return true;
        }
        close();
        return false;
    }
}
