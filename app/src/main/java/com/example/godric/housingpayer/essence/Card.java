package com.example.godric.housingpayer.essence;

/**
 * Created by godric on 18.05.2016.
 */
public class Card {
    private String owner;
    private int year;
    private String number;
    private int _id;

    public Card(int id, String number, int year, String owner) {
        this._id = id;
        this.number = number;
        this.year = year;
        this.owner = owner;
    }

    /////////////////// setters and getter
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
