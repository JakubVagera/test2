package com.example.demo15;

import java.util.Comparator;

class GroupComparator implements Comparator<Words1> {

    public int compare(Words1 s1, Words1 s2)
    {
        if(s1.group> s2.group){
            return 1;
        }else if(s1.group < s2.group) {
            return -1;
        }else {
            return 0;
        }
    }
}
