package com.example.hp.twtnews_mvp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ListApi {
    @GET("news/{type}/page/{page}")
    Call<ListBean> getList(@Path("page") String page, @Path("type") String type);
}
