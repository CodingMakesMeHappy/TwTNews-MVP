package com.example.hp.twtnews_mvp.model;

import com.example.hp.twtnews_mvp.presenter.ContentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ContentApiClient {
    ContentPresenter contentPresenter;

    public ContentApiClient(ContentPresenter contentPresenter) {
        this.contentPresenter = contentPresenter;
    }

    public void loadContent(int index) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://open.twtstudio.com/api/v1/")
                .build();
        ContentApi contentApi = retrofit.create(ContentApi.class);

        Call<ContentBean> call = contentApi.getContent(String.valueOf(index));

        call.enqueue(new Callback<ContentBean>() {
            @Override
            public void onResponse(Call<ContentBean> call, Response<ContentBean> response) {
                contentPresenter.setContent(response.body());
            }

            @Override
            public void onFailure(Call<ContentBean> call, Throwable t) {

            }
        });
    }
}
