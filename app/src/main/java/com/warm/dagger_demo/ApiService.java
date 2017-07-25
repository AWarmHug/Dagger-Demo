package com.warm.dagger_demo;

import com.warm.dagger_demo.bean.BaseEntity;
import com.warm.dagger_demo.bean.Data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/24
 * 简介:
 */
public interface ApiService {

    @GET("data/{type}/20/1")
    Observable<BaseEntity<List<Data>>> getDate(@Path("type") String type);
}
