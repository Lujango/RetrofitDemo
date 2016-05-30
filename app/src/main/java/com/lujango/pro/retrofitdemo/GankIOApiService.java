package com.lujango.pro.retrofitdemo;

import com.lujango.pro.retrofitdemo.model.GankIOResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pro on 16/5/30.
 */
public interface GankIOApiService {
    @GET("/data/福利/{number}/{page}")
    Call<GankIOResult> getBeauties(@Path("number") int number, @Path("page") int page);
}
