package com.example.sleepynhi.cat_game.playableObjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import com.example.sleepynhi.cat_game.R;

/**
 * Created by Sleepynhi on 7/16/17.
 */

public class Player{
    private Bitmap bitmap;

    private static int gold = 10; //gold per click
    //coordinates
    private int x;
    private int y;
    private static int bank;

    public Player(Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bunny);
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getGold() { return gold; }
    public int getBank() {return bank;}
    public void setBank(int bank) {
        this.bank = getBank() + bank;}

}
