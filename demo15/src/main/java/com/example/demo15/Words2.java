package com.example.demo15;

import java.io.Serializable;

public class Words2 implements Serializable {
    String first;
    String space;
    String last;
    String space2;
    int group;
    String space3;
    public Words2(String first, String space, String last,String space2, int group,String space3){
        this.first = first;
        this.space = space;
        this.last = last;
        this.space2 = space2;
        this.group = group;
        this.space3 = space3;
    }
    public String toString(){
        return first+space+last+space2+group+space3;
    }

}
