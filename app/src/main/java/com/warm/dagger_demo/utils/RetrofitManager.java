package com.warm.dagger_demo.utils;

import android.content.Context;
import android.util.Log;

import com.warm.dagger_demo.Api;
import com.warm.dagger_demo.Config;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/24
 * 简介:
 */

public class RetrofitManager {

    private static OkHttpClient mOkHttpClient;

    private static Retrofit retrofit;

    private static void initOkHttpClient(Context context) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        CacheInterceptor cacheInterceptor = new CacheInterceptor(context);
        if (mOkHttpClient == null || retrofit == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {
                    //设置Http缓存
                    Cache cache = new Cache(new File(context
                            .getExternalCacheDir(), "HttpCache"), 1024 * 1024 * 10);


                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor)
                            .addNetworkInterceptor(cacheInterceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .build();
                }
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Config.BASE_URL)
                            .client(mOkHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
    }

    /**
     * 为okhttp添加缓存，这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
     */
    private static class CacheInterceptor implements Interceptor {

        private Context mContext;

        public CacheInterceptor(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {

            // 有网络时 设置缓存超时时间1个小时
            int maxAge = 60*60;
            // 无网络时，设置超时为1天
            int maxStale = 60 * 60 * 24;

            Request request = chain.request();

            if (NetUtil.isNetworkAvailable(mContext)) {
                //有网络时只从网络获取
                request = request.newBuilder()
                        .header("User-Agent","YIXIProject/1.2 ( picsize=iphone6+ ; android 6.0; Scale/2.625)")
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
                Log.d("okhttp", "intercept: 有网络时");
            } else {
                //无网络时只从缓存中读取
                request = request.newBuilder()
                        .header("User-Agent","YIXIProject/1.2 ( picsize=iphone6+ ; android 6.0; Scale/2.625)")
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.d("okhttp", "intercept: 无网络时");
//                Toast.makeText(App.getInstance(), "没有网络", Toast.LENGTH_SHORT).show();
            }

            Response response = chain.proceed(request);


            if (NetUtil.isNetworkAvailable(mContext)) {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();

            }
            return response;
        }
    }

}
