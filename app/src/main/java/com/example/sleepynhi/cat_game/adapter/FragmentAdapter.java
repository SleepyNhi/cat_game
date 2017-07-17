package com.example.sleepynhi.cat_game.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.Pair;

import java.util.ArrayList;

/**
 * Created by Sleepynhi on 7/12/17.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Pair<String,Fragment>> list;

    public FragmentAdapter(FragmentManager fm, ArrayList<Pair<String,Fragment>> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position).second;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).first;
    }
}
