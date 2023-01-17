package com.example.demo15;

import java.io.Serializable;

public class Words1 implements Serializable {
    int verb;
    int preposition;
    String infinitiv;
    String gerundium;
    int group;
    int irregular;
    public Words1(int verb,int preposition, String infinitiv, String gerundium, int group, int irregular){
        this.verb = verb;
        this.preposition = preposition;
        this.infinitiv = infinitiv;
        this.gerundium = gerundium;
        this.group = group;
        this.irregular = irregular;
    }
}