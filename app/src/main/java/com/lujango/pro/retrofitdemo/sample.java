package com.lujango.pro.retrofitdemo;

import com.lujango.pro.retrofitdemo.model.DrunbiBean;
import com.lujango.pro.retrofitdemo.model.GankIOBean;

import java.io.IOException;
import java.util.List;

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
        Api.getDrunBiApiService().rxSearch("逼").subscribe(new Observer<List<DrunbiBean>>() {
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
        });

//        Api.getDrunBiApiService().rxSearch("逼");
     /*   Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        ).subscribe(new Subscriber<String>() {
            @Override
            public void onNext(String s) { System.out.println(s); }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        });*/


    }
}
