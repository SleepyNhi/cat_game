package com.example.sleepynhi.cat_game.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sleepynhi.cat_game.R;

import butterknife.ButterKnife;

public class YardFragment extends Fragment {

    public YardFragment(){

    }

    public static YardFragment newInstance(String param1, String param2) {
        YardFragment fragment = new YardFragment();
        Bundle args = new Bundle();
        return fragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_yardfragment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


}
