package com.example.sleepynhi.cat_game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.sleepynhi.cat_game.dialog.MenuDialog;
import com.example.sleepynhi.cat_game.playableObjects.Player;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends BaseActivity implements View.OnClickListener {

    private int GOLD = 0;


    @OnClick(R.id.activity_game_player)
    public void playerClick(){

        GOLD = GOLD + HomepageActivity.player.getGold();
        goldTV.setText(GOLD + "");
        HomepageActivity.player.setBank(HomepageActivity.player.getGold());

    }


    @OnClick(R.id.activity_gameplay_menu)
    public void menuBt(){
        MenuDialog menuDialog = new MenuDialog(this);
        menuDialog.setCanceledOnTouchOutside(true);
        menuDialog.show();
    }

    @BindView(R.id.totalgold_tv)
    TextView goldTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_activity);
        ButterKnife.bind(this);


    }


    @Override
    public void onClick(View v) {


    }

}
