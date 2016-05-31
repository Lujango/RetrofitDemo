package com.lujango.pro.retrofitdemo;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pro on 16/5/27.
 */
public class Api {
    private static DrunBiApiService apiService;
    private static GankIOApiService gankIOApiService;
    private static DoubanApiService doubanApiService;
    private static OkHttpClient okHttpClient;
    private static String DrunBiBaseUrl = "http://zhuangbi.info/";
    private static String GankIOBaseUrl = "http://gank.io/api/";
    private static String DoubanBaseUrl = "https://api.douban.com/v2/movie/";

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();
        }
        return okHttpClient;
    }

    public static DrunBiApiService getDrunBiApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DrunBiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            apiService = retrofit.create(DrunBiApiService.class);
        }
        return apiService;
    }

    public static GankIOApiService getGankIOApiService() {
        if (gankIOApiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(GankIOBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            gankIOApiService = retrofit.create(GankIOApiService.class);
        }
        return gankIOApiService;
    }

    public static DoubanApiService getDoubanApiService() {
        if (doubanApiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DoubanBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            doubanApiService = retrofit.create(DoubanApiService.class);
        }
        return doubanApiService;
    }
}
