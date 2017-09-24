package com.example.hp.twtnews_mvp.presenter;

import com.example.hp.twtnews_mvp.model.ListBean;


public interface ListPresenter {

    void setListBean(ListBean listBean);

    void loadListBean(int page, int type);

}
