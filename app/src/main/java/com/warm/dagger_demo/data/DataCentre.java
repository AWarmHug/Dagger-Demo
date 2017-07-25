package com.warm.dagger_demo.data;

import com.warm.dagger_demo.bean.BaseEntity;
import com.warm.dagger_demo.bean.Data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * Created by warm on 17/7/25.
 */

public class DataCentre implements HttpHelper{

    private HttpHelper mHttpHelper;

    public DataCentre(HttpHelper mHttpHelper) {
        this.mHttpHelper = mHttpHelper;
    }

    @Override
    public Observable<BaseEntity<List<Data>>> getDate(@Path("type") String type) {
        return mHttpHelper.getDate(type);
    }
}
