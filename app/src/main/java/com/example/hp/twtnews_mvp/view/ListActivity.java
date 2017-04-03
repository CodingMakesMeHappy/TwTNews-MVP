package com.example.hp.twtnews_mvp.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.example.hp.twtnews_mvp.R;
import com.example.hp.twtnews_mvp.adapter.ListAdapter;
import com.example.hp.twtnews_mvp.model.ListApiClient;
import com.example.hp.twtnews_mvp.model.ListBean;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements ListView{

    @Bind(R.id.list_toolbar)
    Toolbar list_toolbar;
    @Bind(R.id.list_recyclerView)
    RecyclerView list_recyclerView;
    @Bind(R.id.list_swipeRefreshLayout)
    SwipeRefreshLayout list_swipeRefreshLayout;
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        System.out.println( "aaaabbb");


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        list_recyclerView.setLayoutManager(linearLayoutManager);

        list_swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                ListApiClient listApiClient = new ListApiClient();
                ListBean listBean = listApiClient.load(1);
//                listAdapter = new ListAdapter(listBean, ListActivity.this);
//                list_recyclerView.setAdapter(listAdapter);
            }
        });

    }

    @Override
    public void setAdapter() {

    }
}
