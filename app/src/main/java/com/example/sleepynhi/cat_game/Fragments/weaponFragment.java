package com.example.sleepynhi.cat_game.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.sleepynhi.cat_game.R;
import com.example.sleepynhi.cat_game.adapter.ListNormalAdapter;
import com.example.sleepynhi.cat_game.dialog.EquipDialog;
import com.example.sleepynhi.cat_game.dialog.buyDialog;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class weaponFragment extends Fragment {
    private final ArrayList<String> contentList;
    private ListView listView;

    public weaponFragment() {
        contentList = new ArrayList<String>();

        contentList.add("Sword");
        contentList.add("Helper1");
        contentList.add("Helper2");
        contentList.add("Helper3");
        contentList.add("Helper4");


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weapon, container, false);
        ButterKnife.bind(this,view);

        listView = (ListView)view.findViewById(R.id.activity_weapon_listview);
        ListNormalAdapter adapter = new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);
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
