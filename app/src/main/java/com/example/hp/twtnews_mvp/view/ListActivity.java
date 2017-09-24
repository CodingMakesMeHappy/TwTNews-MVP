package com.example.hp.twtnews_mvp.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.example.hp.twtnews_mvp.R;
import com.example.hp.twtnews_mvp.adapter.ListPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {


    @Bind(R.id.list_toolbar)
    Toolbar list_toolbar;
    @Bind(R.id.list_tabLayout)
    TabLayout list_tabLayout;
    @Bind(R.id.list_pager)
    ViewPager list_pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        ListPagerAdapter listPagerAdapter = new ListPagerAdapter(getSupportFragmentManager());
        listPagerAdapter.add(ListFragment.newInstance(1), "新闻类别1");
        listPagerAdapter.add(ListFragment.newInstance(3), "新闻类别2");
        listPagerAdapter.add(ListFragment.newInstance(3), "新闻类别3");
        listPagerAdapter.add(ListFragment.newInstance(4), "新闻类别4");

        list_pager.setAdapter(listPagerAdapter);
        list_tabLayout.setupWithViewPager(list_pager);
        list_tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

    }

}
