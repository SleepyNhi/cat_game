package com.example.sleepynhi.cat_game.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sleepynhi.cat_game.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

import com.example.sleepynhi.cat_game.adapter.ListNormalAdapter;
import com.example.sleepynhi.cat_game.dialog.buyDialog;
import com.example.sleepynhi.cat_game.playableObjects.itemsObject;

/**
 * Created by Sleepynhi on 7/12/17.
 */

public class ShopFragment extends Fragment {
    private final ArrayList<String> contentList;
    private ListView listView;


    public ShopFragment() {
        contentList = new ArrayList<String>();

        contentList.add("Attack Boost");
        contentList.add("Helper1");
        contentList.add("Helper2");
        contentList.add("Helper3");
        contentList.add("Helper4");


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_shopfragment, container, false);
        ButterKnife.bind(this,view);

        listView = (ListView)view.findViewById(R.id.activity_shop_listview);
        ListNormalAdapter adapter1 = new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        showDialog();
                        break;
                    case 1:
                        showDialog();

                        break;
                    case 2:
                        showDialog();

                        break;
                    default:
                        break;
                }
            }
        });
        return view;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void showDialog(){
        buyDialog buyDialog1 = new buyDialog(getContext());
        buyDialog1.setCanceledOnTouchOutside(true);
        buyDialog1.show();
    }
}
