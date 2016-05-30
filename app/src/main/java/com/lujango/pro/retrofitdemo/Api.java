package com.lujango.pro.retrofitdemo;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pro on 16/5/27.
 */
public class Api {
    private static DrunBiApiService apiService;
    private static GankIOApiService gankIOApiService;
    private static OkHttpClient okHttpClient;
    private static String DrunBiBaseUrl = "http://zhuangbi.info/";
    private static String GankIOBaseUrl = "http://gank.io/api/";

    private static OkHttpClient getClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (okHttpClient==null){
            okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(httpLoggingInterceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
        }
        return okHttpClient;
    }

    public static DrunBiApiService getDrunBiApiService(){
        if (apiService==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DrunBiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
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
                    .client(getClient())
                    .build();
            gankIOApiService = retrofit.create(GankIOApiService.class);
        }
        return gankIOApiService;
    }
}
