package com.lujango.pro.retrofitdemo;

import android.util.Log;

import com.lujango.pro.retrofitdemo.model.DoubanResult;
import com.lujango.pro.retrofitdemo.model.DrunbiBean;
import com.lujango.pro.retrofitdemo.model.GankIOBean;
import com.lujango.pro.retrofitdemo.model.Subject;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by pro on 16/5/30.
 */
public class sample {
    public static void main(String... args) throws IOException {
       /* DrunBiApiService drunbility = Api.getDrunBiApiService();
        for (DrunbiBean bean:drunbility.search("逼").execute().body()) {
            System.out.println(bean.description);
            System.out.println(bean.image_url);
        }*/

        /*GankIOApiService gankIOApiService = Api.getGankIOApiService();
        for (GankIOBean bean : gankIOApiService.getBeauties(10, 1).execute().body().beauties) {
            System.out.println(bean.desc);
            System.out.println(bean.url);
        }*/

        //rx
     /*   Api.getDrunBiApiService().rxSearch("逼").subscribe(new Observer<List<DrunbiBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<DrunbiBean> drunbiBeen) {
                for (DrunbiBean bean:drunbiBeen) {
                    System.out.println(bean.description);
                    System.out.println(bean.image_url);
                }
            }
        });*/

        Api.getDoubanApiService().getMovieTop250(0,250).subscribe(new Observer<DoubanResult<List<Subject>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DoubanResult<List<Subject>> listDoubanResult) {
                for (Subject suj : listDoubanResult.getSubjects()) {
                    System.out.println(suj.getTitle()+""+suj.getYear());
                    System.out.println(suj.getImages().getLarge());
                }
            }
        });



        ///chinalifeweb/applogin
        //https://api.github.com/repos/square/okhttp/contributors
       /* final OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("username","15583581921");
        builder.add("password","123456");
        builder.add("_spring_security_remember_me","true");
        final Request request = new Request.Builder()
                .url("http://www.5rc.com.cn/chinalifeweb/applogin")
                .post(builder.build())
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure:"+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });*/


    }
}
