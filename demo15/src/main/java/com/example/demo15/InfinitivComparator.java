package com.example.demo15;


import java.util.Comparator;

class InfinitivComparator implements Comparator<Words1> {

    // override the compare() method
    public int compare(Words1 s1, Words1 s2)
    {
        return s1.infinitiv.compareTo(s2.infinitiv);
    }
}
