package com.example.hp.twtnews_mvp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by HP on 2017/4/3.
 */

public interface ListApi {
    @GET ("news/1/page/{page}")
    Call<ListBean> getList(@Path("page") String page);
}
