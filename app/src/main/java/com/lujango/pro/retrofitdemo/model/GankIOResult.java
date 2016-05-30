package com.lujango.pro.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pro on 16/5/30.
 */
public class GankIOResult {
    public boolean error = false;
    //SerializedName 用于json里面的字段名
    public @SerializedName("results")
    List<GankIOBean> beauties;
}
