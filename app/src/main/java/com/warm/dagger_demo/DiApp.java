package com.warm.dagger_demo;

import android.app.Application;
import android.util.Log;

import com.warm.dagger_demo.di.components.DaggerDiAppComponent;
import com.warm.dagger_demo.di.components.DiAppComponent;
import com.warm.dagger_demo.di.modules.DiAppModule;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */

public class DiApp extends Application {
    private static final String TAG = "DiApp";;

    private DiAppComponent diAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        diAppComponent= DaggerDiAppComponent.builder().diAppModule(new DiAppModule(this)).build();
    }

    public DiAppComponent getDiAppComponent(){
        return diAppComponent;
    }

}
