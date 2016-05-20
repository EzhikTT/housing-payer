package com.example.godric.housingpayer.essence;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by godric on 19.05.2016.
 */
public class Period {

    private int id;
    private String starting;
    private String ending;
    private int value;

    public Period(String starting, String ending) {
        this.starting = starting;
        this.ending = ending;
        this.id = 0;
    }

    public Period(int id, String starting, String ending, int value) {
        this.starting = starting;
        this.ending = ending;
        this.id = id;
        this.value = value;
    }

    public Period(int sy, int sm, int sd, int ey, int em, int ed) {
        this.starting = sd + "/" + sm + "/"+ sy;
        this.ending = ed + "/" + em + "/" + ey;
    }

    public static Period fromString(String str) {
        String s = str.substring(0, str.indexOf('/', 0));
        String e = str.substring(str.indexOf('/', 0) + 1, str.length());
        return new Period(s, e);
    }

    public String getStarting() {
        return this.starting;
    }

    public String getEnding() {
        return this.ending;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return starting.toString() + " - " + ending.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
