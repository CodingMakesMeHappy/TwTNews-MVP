package com.example.hp.twtnews_mvp.presenter;

import com.example.hp.twtnews_mvp.model.ContentBean;


public interface ContentPresenter {
    public void loadContent(int index);

    public void setContent(ContentBean contentBean);
}
