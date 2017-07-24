package com.warm.dagger_demo.di.components;

import com.warm.dagger_demo.Api;
import com.warm.dagger_demo.di.modules.ApiModule;
import com.warm.dagger_demo.presenter.BasePresenter;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/24
 * 简介:
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {

    OkHttpClient getClient();
    Retrofit getRetrofit();
    Api getApi();



}
