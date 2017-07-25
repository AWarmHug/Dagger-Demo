package com.warm.dagger_demo.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Module
public class ActivityModule {

    private Activity mActivity;


    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    public Activity provideMainView(){
        return mActivity;
    }
}
