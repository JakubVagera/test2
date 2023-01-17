package com.example.demo15;


public class Groups {
    int number;
    int count;
    int amount;
    public Groups(int number, int count,int amount){
        this.number = number;
        this.count = count;
        this.amount = amount;
    }
    public String toString(){
        return number+ " " + count+ " " + amount;
    }
}
