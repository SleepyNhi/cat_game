package com.example.sleepynhi.cat_game.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.sleepynhi.cat_game.GestureActivity;
import com.example.sleepynhi.cat_game.HomepageActivity;
import com.example.sleepynhi.cat_game.InventoryActivity;
import com.example.sleepynhi.cat_game.R;
import com.example.sleepynhi.cat_game.ShopActivity;
import com.example.sleepynhi.cat_game.TestAudioActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Sleepynhi on 7/12/17.
 */

public class MenuDialog extends Dialog{

    @OnClick(R.id.menu_box1)
    public void box1Bt(View view){
        Intent intent = new Intent(getContext(), HomepageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getContext().startActivity(intent);
    }
    @OnClick(R.id.menu_box2)
    public void box2Bt(View view){
        Intent intent = new Intent(getContext(), ShopActivity.class);
        getContext().startActivity(intent);
    }
    @OnClick(R.id.menu_box3)
    public void box3Bt(View view){
        Intent intent = new Intent(getContext(), InventoryActivity.class);
        getContext().startActivity(intent);
    }
    @OnClick(R.id.menu_box4)
    public void box4Bt(View view){
        Intent intent2 = new Intent(getContext(), TestAudioActivity.class);
        getContext().startActivity(intent2);

    }

    public MenuDialog(@NonNull Context context) {
        super(context,R.style.dialog);
        setContentView(R.layout.activity_menu_dialog);
        ButterKnife.bind(this);

    }

    public interface iMenuListener{
        public void onOKClicked(String msg);

    }


}
