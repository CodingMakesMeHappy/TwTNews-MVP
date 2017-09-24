package com.example.hp.twtnews_mvp.model;

import com.example.hp.twtnews_mvp.presenter.ListPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListApiClient {
    ListPresenter listPresenter;

    public ListApiClient(ListPresenter listPresenter) {
        this.listPresenter = listPresenter;
    }

    public void loadList(int page, int type) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://open.twtstudio.com/api/v1/")
                .build();

        ListApi listApi = retrofit.create(ListApi.class);

        Call<ListBean> call = listApi.getList(String.valueOf(page), String.valueOf(type));

        call.enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                if (response.isSuccessful()) {
                    listPresenter.setListBean(response.body());
                } else {
                }
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {

            }
        });
    }

}
