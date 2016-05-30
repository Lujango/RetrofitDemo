package com.lujango.pro.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pro on 16/5/27.
 */
public class Api {
    private static DrunBiApiService apiService;
    private static GankIOApiService gankIOApiService;
    private static String DrunBiBaseUrl = "http://zhuangbi.info/";
    private static String GankIOBaseUrl = "http://gank.io/api/";

    public static DrunBiApiService getDrunBiApiService(){
        if (apiService==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DrunBiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(DrunBiApiService.class);
        }
        return apiService;
    }

    public static GankIOApiService getGankIOApiService(){
        if (gankIOApiService==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(GankIOBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            gankIOApiService = retrofit.create(GankIOApiService.class);
        }
        return gankIOApiService;
    }
}
