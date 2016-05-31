package com.lujango.pro.retrofitdemo;

import com.lujango.pro.retrofitdemo.model.DoubanResult;
import com.lujango.pro.retrofitdemo.model.Subject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pro on 16/5/31.
 */
public interface DoubanApiService {
    @GET("top250")
    Observable<DoubanResult<List<Subject>>> getMovieTop250(@Query("start") int start, @Query("count") int count);
}
