package com.lujango.pro.retrofitdemo;

import com.lujango.pro.retrofitdemo.model.DrunbiBean;
import com.lujango.pro.retrofitdemo.model.GankIOBean;

import java.io.IOException;

/**
 * Created by pro on 16/5/30.
 */
public class sample {
    public static void main(String... args) throws IOException{
       /* DrunBiApiService drunbility = Api.getDrunBiApiService();
        for (DrunbiBean bean:drunbility.search("逼").execute().body()) {
            System.out.println(bean.description);
            System.out.println(bean.image_url);
        }*/

        GankIOApiService gankIOApiService = Api.getGankIOApiService();
        for (GankIOBean bean:gankIOApiService.getBeauties(10,1).execute().body().beauties){
            System.out.println(bean.desc);
            System.out.println(bean.url);
        }
    }
}
