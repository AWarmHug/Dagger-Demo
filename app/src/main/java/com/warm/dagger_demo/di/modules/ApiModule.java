package com.warm.dagger_demo.di.modules;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.warm.dagger_demo.Api;
import com.warm.dagger_demo.BuildConfig;
import com.warm.dagger_demo.Config;
import com.warm.dagger_demo.utils.CacheInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/24
 * 简介:
 */
@Module
public class ApiModule {
    private static final String TAG = "ApiModule";
    private Context mContext;

    public ApiModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    public Interceptor provideInterceptor(){

        return new CacheInterceptor(mContext);
    }


    @Provides
    @Singleton
    public OkHttpClient provideClient( Interceptor cacheInterceptor) {
        //设置Http缓存
        Cache cache = new Cache(new File(mContext
                .getExternalCacheDir(), "HttpCache"), 1024 * 1024 * 10);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(cacheInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG){
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client){
        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Log.d(TAG, "provideRetrofit: ");
        return retrofit;
    }


    @Provides
    @Singleton
    public Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }




}
