package com.example.sleepynhi.cat_game.playableObjects;

/**
 * Created by Sleepynhi on 7/16/17.
 */

public class itemsObject {

    private int Attack;
    private int price;
    public itemsObject(int attack, int price){
        Attack = attack;
        this.price = price;

    }

    public int returnAttack(){
        return Attack;
    }
    public int returnPrice(){
        return price;
    }
}
