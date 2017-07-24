package com.warm.dagger_demo.di.modules;

import android.content.Context;

import com.warm.dagger_demo.di.components.ApiComponent;
import com.warm.dagger_demo.di.components.DaggerApiComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Module
public class DiAppModule {

    private Context mContext;

    public DiAppModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return mContext;
    }

    @Provides
    @Singleton
    public ApiComponent provideApiComponent(){
        return DaggerApiComponent.builder().apiModule(new ApiModule(mContext)).build();

    }


}
