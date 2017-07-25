package com.warm.dagger_demo.di.modules;

import android.content.Context;

import com.warm.dagger_demo.data.DataCentre;
import com.warm.dagger_demo.data.HttpHelper;
import com.warm.dagger_demo.data.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return mContext;
    }

    @Provides
    @Singleton
    public HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper){
        return retrofitHelper;
    }


    @Provides
    @Singleton
    public DataCentre provideDataCentre(RetrofitHelper retrofitHelper){
        return new DataCentre(retrofitHelper);
    }


}
