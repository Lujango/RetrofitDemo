package com.lujango.pro.retrofitdemo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pro on 16/5/27.
 */
public class Zhuangbility {
    public static final String API_URL = "http://zhuangbi.info";
    public static class DrunbiBean{
        public String description;
        public String image_url;
    }

    public interface Drunbility{
        @GET("/search")
        Call<List<DrunbiBean>> search(@Query("q") String query);
    }


    public static void main(String... args) throws IOException{
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Drunbility drunbility = retrofit.create(Drunbility.class);
        for (DrunbiBean bean:drunbility.search("逼").execute().body()) {
            System.out.println(bean.description);
            System.out.println(bean.image_url);
        }
    }

}
