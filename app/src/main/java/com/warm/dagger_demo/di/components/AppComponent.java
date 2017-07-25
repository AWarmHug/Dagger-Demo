package com.warm.dagger_demo.di.components;

import android.content.Context;

import com.warm.dagger_demo.data.DataCentre;
import com.warm.dagger_demo.data.RetrofitHelper;
import com.warm.dagger_demo.di.modules.ApiModule;
import com.warm.dagger_demo.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Component(modules = {AppModule.class, ApiModule.class})
@Singleton
public interface AppComponent {

    Context getContext();

    RetrofitHelper getRetrofitHelper();

    DataCentre getDataCentre();






}
