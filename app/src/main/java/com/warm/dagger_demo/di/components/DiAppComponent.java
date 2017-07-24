package com.warm.dagger_demo.di.components;

import android.content.Context;

import com.warm.dagger_demo.Api;
import com.warm.dagger_demo.di.modules.ApiModule;
import com.warm.dagger_demo.di.modules.DiAppModule;
import com.warm.dagger_demo.presenter.BasePresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Component(modules = {DiAppModule.class})
@Singleton
public interface DiAppComponent {

    Context getContext();

    ApiComponent getApiComponent();


}
