package com.example.sleepynhi.cat_game;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sleepynhi.cat_game.Fragments.ShopFragment;
import com.example.sleepynhi.cat_game.Fragments.weaponFragment;
import com.example.sleepynhi.cat_game.adapter.ListNormalAdapter;
import com.example.sleepynhi.cat_game.adapter.ViewFragmentStateAdapter;
import com.example.sleepynhi.cat_game.dialog.MenuDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopActivity extends BaseActivity {

    private ArrayList<String> contentList;


    private ArrayList list = new ArrayList();

    @BindView(R.id.activity_shop_goldtv)
    TextView goldTV;

    @BindView(R.id.activity_advance_view_pager_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;
    private ListView listView;

    @OnClick(R.id.activity_shop_menubt)
    public void menubt(View view){
        MenuDialog menuDialog = new MenuDialog(this);
        menuDialog.setCanceledOnTouchOutside(true);
        menuDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);
        list.add(new Pair<String, Fragment>("FOOD", new ShopFragment()));
        list.add(new Pair<String, Fragment>("WEAPON", new weaponFragment()));

        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        getTotalBank();
    }

    public void getTotalBank(){

        goldTV.setText(HomepageActivity.player.getBank() + "");
    }


}
