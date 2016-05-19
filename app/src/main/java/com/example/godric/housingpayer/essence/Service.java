package com.example.godric.housingpayer.essence;

import com.example.godric.housingpayer.data.MyArray;

import java.util.ArrayList;

/**
 * Created by godric on 19.05.2016.
 */
public class Service {
    private int _id;
    private String name;
    private String description;
    private int price;
    private ArrayList<Period> period;
    private String periodString;

    public Service(int id, String name, int price, String period) {
        this.name = name;
        //this.description = description;
        this.price = price;
        this._id = id;
        this.periodString = period;
    }

    /////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getPeriodString() {
        return periodString;
    }

    public void setPeriodString(String periodString) {
        this.periodString = periodString;
    }

    public ArrayList<Period> getPeriod() {
        return period;
    }

    public void setPeriod(ArrayList<Period> period) {
        this.period = period;
    }
}
