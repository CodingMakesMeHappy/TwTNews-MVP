package com.example.hp.twtnews_mvp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContentApi {
    @GET("news/{index}")
    Call<ContentBean> getContent(@Path("index") String index);
}
