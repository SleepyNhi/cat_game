package com.example.sleepynhi.cat_game.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sleepynhi.cat_game.HomepageActivity;
import com.example.sleepynhi.cat_game.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Sleepynhi on 7/12/17.
 */

public class EquipDialog extends Dialog {


    @OnClick(R.id.activity_equipbt)
    public void equipBt(View view){
        cancel();
    }
    @OnClick(R.id.activity_removebt)
    public void box2Bt(){
        cancel();
    }

    public EquipDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        setContentView(R.layout.activity_equip_dialog);
        ButterKnife.bind(this);
    }





}
