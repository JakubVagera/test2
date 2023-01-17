package com.example.demo15;

import java.util.Comparator;


class PerfectumComparator implements Comparator<Words1> {

    // override the compare() method
    public int compare(Words1 s1, Words1 s2)
    {
        return s1.gerundium.compareTo(s2.gerundium);
    }
}
