package com.example.godric.housingpayer.essence;

/**
 * Created by godric on 19.05.2016.
 */
public class Service {
    private String name;
    private String description;
    private int price;
    private int _id;

    public Service(String name, String description, int price, int id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this._id = id;
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
}
