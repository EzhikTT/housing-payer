package com.example.godric.housingpayer.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by godric on 19.05.2016.
 */
public class MyUserDataSource extends DataSource {

    private String[] allColumns = {DBHelper.USER_NAME, DBHelper.USER_PASS};

    public MyUserDataSource(Context context) {
        super(context);
    }

    public boolean addUser(String name, String pass) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.USER_NAME, name);
        values.put(DBHelper.USER_PASS, pass);
        long insertId = database.insert(DBHelper.TABLE_USER, null, values);
        close();
        if (insertId == -1)
            return false;
        return true;
    }

    public boolean isLoginAccept(String name, String pass) {
        open();
        Cursor cursor = database.query(DBHelper.TABLE_USER,
                allColumns, DBHelper.USER_NAME + "=?",
                new String[]{name}, null, null, null);
        if (cursor.getCount() == 0) {
            return false;
        }
        cursor.moveToFirst();
        if (name.equals(cursor.getString(0)) && pass.equals(cursor.getString(1))) {
            return true;
        }
        close();
        return false;
    }
}
