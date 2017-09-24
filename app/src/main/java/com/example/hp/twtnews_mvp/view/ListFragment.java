package com.example.hp.twtnews_mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.twtnews_mvp.R;
import com.example.hp.twtnews_mvp.adapter.ListAdapter;
import com.example.hp.twtnews_mvp.model.ListBean;
import com.example.hp.twtnews_mvp.presenter.ListPresenter;
import com.example.hp.twtnews_mvp.presenter.ListPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ListFragment extends Fragment implements ListFragmentView {

    int page = 1;
    boolean isLoading = false;


    @Bind(R.id.list_recyclerView)
    RecyclerView list_recyclerView;
    @Bind(R.id.list_swipeRefreshLayout)
    SwipeRefreshLayout list_swipeRefreshLayout;
    ListAdapter listAdapter;

    //   @Inject
    ListBean listBean = new ListBean();
    ListPresenter listPresenter = new ListPresenterImpl(this);

    public static ListFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("index", type);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ButterKnife.bind(this, view);
        listAdapter = new ListAdapter(listBean, getActivity());
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        list_recyclerView.setLayoutManager(linearLayoutManager);
        list_recyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL, 20, R.color.divider));
        Bundle bundle = getArguments();
        final int type = bundle.getInt("index");

//        Component component =  DaggerComponent.builder().module(new Module()).build();
//        component.inject(this);


        list_swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                listPresenter.loadListBean(page, type);
                list_recyclerView.setAdapter(listAdapter);
            }
        });

        list_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listBean.data.clear();
                page = 1;
                listPresenter.loadListBean(page, type);
            }
        });
        list_recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalCount < (lastVisibleItem + 2)) {
                    ++page;
                    isLoading = true;
                    listPresenter.loadListBean(page, type);
                }
            }
        });
        return view;
    }

    @Override
    public void setAdapter(ListBean listBean) {
        this.listBean.error_code = listBean.error_code;
        this.listBean.message = listBean.message;
        this.listBean.data.addAll(listBean.data);
        listAdapter.notifyDataSetChanged();
        list_swipeRefreshLayout.setRefreshing(false);
        isLoading = false;
    }
}
