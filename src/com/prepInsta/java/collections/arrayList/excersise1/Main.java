package com.prepInsta.java.collections.arrayList.excersise1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String args[])
    {
        ArrayList<DateItem> dateList = new ArrayList<>();
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2019-01-27"));
        dateList.add(new DateItem("1998-01-27"));
        dateList.add(new DateItem("1998-02-26"));
        Collections.sort(dateList, new sortitems());

        System.out.println("Sorted in Ascending Order");

        for (DateItem d : dateList) {
            System.out.println(d.date);
        }
    }
}
