package com.example.hp.twtnews_mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.hp.twtnews_mvp.R;
import com.example.hp.twtnews_mvp.model.ContentBean;
import com.example.hp.twtnews_mvp.presenter.ContentPresenter;
import com.example.hp.twtnews_mvp.presenter.ContentPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContentActivity extends AppCompatActivity implements ContentView {

    @Bind(R.id.content_toolbar)
    Toolbar content_toolbar;
    @Bind(R.id.content_title)
    TextView content_title;
    @Bind(R.id.content_story)
    WebView content_story;
    ContentPresenter contentPresenter = new ContentPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        int index = bundle.getInt("index");
        contentPresenter.loadContent(index);
    }

    @Override
    public void setDate(ContentBean contentBean) {
        content_title.setText(contentBean.data.subject);
        content_story.loadDataWithBaseURL(null, contentBean.data.content, "text/html", "utf-8", null);
    }
}
