package com.lujango.pro.retrofitdemo;

import com.lujango.pro.retrofitdemo.model.DrunbiBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pro on 16/5/27.
 */
public interface ApiService {
    @GET("/search")
    Call<List<DrunbiBean>> search(@Query("q") String query);


}