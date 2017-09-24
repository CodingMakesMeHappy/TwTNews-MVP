package com.example.hp.twtnews_mvp.presenter;

import com.example.hp.twtnews_mvp.model.ListApiClient;
import com.example.hp.twtnews_mvp.model.ListBean;
import com.example.hp.twtnews_mvp.view.ListFragmentView;


public class ListPresenterImpl implements ListPresenter {
    ListFragmentView listFragmentView;
    ListApiClient listApiClient = new ListApiClient(this);

    public ListPresenterImpl(ListFragmentView listFragmentView) {
        this.listFragmentView = listFragmentView;
    }

    @Override
    public void setListBean(ListBean listBean) {
        listFragmentView.setAdapter(listBean);
    }

    @Override
    public void loadListBean(int page, int type) {
        listApiClient.loadList(page, type);
    }
}
