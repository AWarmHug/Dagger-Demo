package com.warm.dagger_demo.presenter;

import com.warm.dagger_demo.Api;
import com.warm.dagger_demo.DiApp;
import com.warm.dagger_demo.di.components.DaggerDiAppComponent;
import com.warm.dagger_demo.di.modules.ApiModule;
import com.warm.dagger_demo.di.modules.DiAppModule;

import javax.inject.Inject;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/24
 * 简介:
 */

public class BasePresenter {
    Api mApi;

    public BasePresenter() {
        mApi= DiApp.getDiAppComponent().getApiComponent().getApi();
    }
}
