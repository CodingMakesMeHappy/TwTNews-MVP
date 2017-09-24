package com.example.hp.twtnews_mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentsOfList = new ArrayList<>();
    List<String> fragmentsTitles = new ArrayList<>();

    public ListPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void add(Fragment fragment, String title) {
        fragmentsOfList.add(fragment);
        fragmentsTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsOfList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsOfList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsTitles.get(position);
    }
}
