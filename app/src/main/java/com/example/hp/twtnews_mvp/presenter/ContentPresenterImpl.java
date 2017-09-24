package com.example.hp.twtnews_mvp.presenter;

import com.example.hp.twtnews_mvp.model.ContentApiClient;
import com.example.hp.twtnews_mvp.model.ContentBean;
import com.example.hp.twtnews_mvp.view.ContentView;


public class ContentPresenterImpl implements ContentPresenter {
    ContentView contentView;
    ContentApiClient contentApiClient = new ContentApiClient(this);

    public ContentPresenterImpl(ContentView contentView) {
        this.contentView = contentView;
    }

    @Override
    public void loadContent(int index) {
        contentApiClient.loadContent(index);
    }

    @Override
    public void setContent(ContentBean contentBean) {
        contentView.setDate(contentBean);
    }
}
