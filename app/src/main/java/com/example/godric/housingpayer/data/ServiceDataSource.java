package com.example.godric.housingpayer.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.godric.housingpayer.essence.Card;
import com.example.godric.housingpayer.essence.Period;
import com.example.godric.housingpayer.essence.Service;

import java.util.ArrayList;

/**
 * Created by godric on 19.05.2016.
 */
public class ServiceDataSource extends DataSource {

    private String[] periodcolums = { DBHelper.ID,
            DBHelper.PERIOD_STARTING, DBHelper.PERIOD_ENDING,
            DBHelper.PERIOD_VALUE};
    private String[] allColumns = { DBHelper.ID,
            DBHelper.SERVICE_NAME,
            DBHelper.SERVICE_PRICE, DBHelper.SERVICE_PERIOD };

    public ServiceDataSource(Context context) {
        super(context);
    }


    public Service getServiceByName(String name) {
        open();
        Cursor cursor = database.query(DBHelper.TABLE_SERVICES,
                allColumns, DBHelper.SERVICE_NAME + "=?",
                new String[]{name}, null, null, null);
        if (cursor.getCount() == 0) {
            cursor.close();
            close();
            return null;
        }
        cursor.moveToFirst();
        Service res = new Service(cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2), cursor.getString(3));
        cursor.close();
        close();
        return res;
    }

    public ArrayList<Service> getAllServices() {
        open();
        ArrayList<Service> res = new ArrayList<Service>();

        Cursor cursor = database.query(DBHelper.TABLE_SERVICES,
                allColumns, null, null, null, null, null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                res.add(new Service(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2), cursor.getString(3)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return res;
    }

    public void updatePeriodOfService(Service s) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.SERVICE_NAME, s.getName());
        values.put(DBHelper.SERVICE_PRICE, s.getPrice());
        values.put(DBHelper.SERVICE_PERIOD, MyArray.toStringPeriod(s.getPeriod(), '|'));

        // updating row
        database.update(DBHelper.TABLE_SERVICES, values, DBHelper.ID + " = ?",
                new String[] { String.valueOf(s.get_id()) });
        close();
    }

    public void removePeriod(int id) {
        open();
        database.delete(DBHelper.TABLE_PERIOD, DBHelper.ID + "=?",
                new String[] { String.valueOf(id) });
        close();
    }

    public int createPeriod(String starting, String ending, int value) {
        open();
        ContentValues values = new ContentValues();
        values.put(DBHelper.PERIOD_STARTING, starting);
        values.put(DBHelper.PERIOD_ENDING, ending);
        values.put(DBHelper.PERIOD_VALUE, value);

        long insertId = database.insert(DBHelper.TABLE_PERIOD, null, values);
        return (int) insertId;
    }

    public ArrayList<Period> getAllPeriods() {
        open();
        ArrayList<Period> periods = new ArrayList<Period>();

        Cursor cursor = database.query(DBHelper.TABLE_PERIOD,
                periodcolums, null, null, null, null, null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                periods.add(new Period(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return periods;
    }

}
