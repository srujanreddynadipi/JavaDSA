package com.prepInsta.java.collections.arrayList.excersise1;

import java.util.Comparator;

    class sortitems implements Comparator<DateItem> {

        @Override
        public int compare(DateItem a, DateItem b) {
            return a.date.compareTo(b.date);
        }
    }


