package com.example.hp.twtnews_mvp.model;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListApiClient {
    ListBean listBean;

    public ListBean load(int page) {
        System.out.println(" public ListBean load(int page) {");
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://open.twtstudio.com/api/v1/")
                .build();

        ListApi listApi = retrofit.create(ListApi.class);

        Call<ListBean> call = listApi.getList(String.valueOf(page));

        call.enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                if (response.isSuccessful()) {
                    listBean = response.body();
                    System.out.println("suaaaa" + listBean.error_code);

                } else {
                System.out.println("failaaaa");
                }
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {
                System.out.println("Failaaaa");
            }
        });
        return listBean;
    }
}
