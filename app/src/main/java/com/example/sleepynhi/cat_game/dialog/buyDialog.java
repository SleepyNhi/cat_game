package com.example.sleepynhi.cat_game.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sleepynhi.cat_game.GameActivity;
import com.example.sleepynhi.cat_game.HomepageActivity;
import com.example.sleepynhi.cat_game.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;

/**
 * Created by Sleepynhi on 7/12/17.
 */

public class buyDialog extends Dialog {

//    @BindView(R.id.imageView)
//    ImageView imageView;
    @OnClick(R.id.activity_buybt)
    public void buyBt(View view){
//        int check = HomepageActivity.player.getBank();
//        if (check < 1000){
//            cancel();
//            Toast.makeText(getContext(),"Not Enough Money",Toast.LENGTH_SHORT);
//        }
//        else {
//            HomepageActivity.player.setBank(check - 1000);
//            cancel();
//        } get shopping to work


    }
    @OnClick(R.id.activity_cancelbt)
    public void cancelBt(){
        cancel();
    }
    @BindView(R.id.buy_cost_tv)
    TextView tv;

    public buyDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        setContentView(R.layout.activity_buy_dialog);
        ButterKnife.bind(this);


//        tv.setText(); get gold price of item
    }

//    public void setBackgroundImage(int res){
//        this.imageView.setBackgroundResource(res);
//
//    } tried to set different images for dialog...


}
