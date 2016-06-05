package com.example.godric.housingpayer.data;

import com.example.godric.housingpayer.essence.Period;

import java.util.ArrayList;

public class MyArray{

    public static String toStringPeriod(ArrayList<Period> arr, char sep) {
        String res = "";
        for (int i = 0; i < arr.size(); ++i) {
            res = res + arr.get(i).getId() + sep;
        }
        return res;
    }

    public static ArrayList<Integer> intArrFromString(String str, char sep) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (str != null && !str.isEmpty()) {
            int start = 0;
            int end = str.indexOf(sep, start);
            while (end > 0) {
                res.add(Integer.parseInt(str.substring(start, end)));
                start = end+1;
                end = str.indexOf(sep, start);
            }
        }
        return res;
    }

    public static ArrayList<String> strArrFromString(String str, char sep) {
        ArrayList<String> res = new ArrayList<String>();
        if (str != null && !str.isEmpty()) {
            int start = 0;
            int end = str.indexOf(sep, start);
            while (end > 0) {
                res.add(str.substring(start, end));
                start = end+1;
                end = str.indexOf(sep, start);
            }
        }
        return res;
    }
}