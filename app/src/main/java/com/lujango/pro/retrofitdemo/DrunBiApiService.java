package com.lujango.pro.retrofitdemo;

import com.lujango.pro.retrofitdemo.model.DrunbiBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pro on 16/5/27.
 */
public interface DrunBiApiService {
    @GET("search")
    Call<List<DrunbiBean>> search(@Query("q") String query);

    @GET("search")
    Observable<List<DrunbiBean>> rxSearch(@Query("q") String query);
}
