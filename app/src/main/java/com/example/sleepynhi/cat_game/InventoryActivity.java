package com.example.sleepynhi.cat_game;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.sleepynhi.cat_game.adapter.ListNormalAdapter;
import com.example.sleepynhi.cat_game.dialog.EquipDialog;
import com.example.sleepynhi.cat_game.dialog.MenuDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InventoryActivity extends BaseActivity {

    private int checkedID;
    @BindView(R.id.activity_radio_group)
    RadioGroup radioGroup;
    @OnClick(R.id.activity_radio_group_submit)
    public void ok(View view){
        shortToast("You chose RadioButton:"+checkedID);
        EquipDialog equipDialog = new EquipDialog(this);
        equipDialog.setCanceledOnTouchOutside(true);
        equipDialog.show();
    }

    @OnClick(R.id.activity_inventory_menu)
    public void menubt(View view){
        MenuDialog menuDialog = new MenuDialog(this);
        menuDialog.setCanceledOnTouchOutside(true);
        menuDialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID= checkedId;
                shortToast("You chose:" + checkedId);
            }
        });

    }

}
