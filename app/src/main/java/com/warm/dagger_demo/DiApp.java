package com.warm.dagger_demo;

import android.app.Application;

import com.warm.dagger_demo.di.components.DaggerAppComponent;
import com.warm.dagger_demo.di.components.AppComponent;
import com.warm.dagger_demo.di.modules.ApiModule;
import com.warm.dagger_demo.di.modules.AppModule;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */

public class DiApp extends Application {
    private static final String TAG = "DiApp";;

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).apiModule(new ApiModule(this)).build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

}
