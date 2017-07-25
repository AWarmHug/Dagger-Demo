package com.warm.dagger_demo.data;

import com.warm.dagger_demo.ApiService;
import com.warm.dagger_demo.bean.BaseEntity;
import com.warm.dagger_demo.bean.Data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * Created by warm on 17/7/25.
 */

public class RetrofitHelper implements HttpHelper {
    private ApiService mApiService;

    @Inject
    public RetrofitHelper(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseEntity<List<Data>>> getDate(@Path("type") String type) {
        return mApiService.getDate(type);
    }
}
